<template>
    <div class="uploader">
        <!-- <el-button type="primary" @click="addImage()" style="margin-top : 2em ; margin-bottom : 1em">Add Photo</el-button> -->
        <input
            type="file"
            id="file-input"
            
            accept="image/*"
            @change="onImageAdded"
            style="display : none"
        />

        <div
            class="card upload-card"
            @click="openFileDialog"
            v-if="!isThumbnailVisible"
        >
            <svg
                class="icon"
                width="28"
                height="28"
                viewBox="0 0 1024 1024"
                xmlns="http://www.w3.org/2000/svg"
            >
                <path
                    fill="#8c939d"
                    d="M480 480V128a32 32 0 0164 0v352h452a32 32 0 110 64H544v352a32 32 0 11-64 0V544H128a32 32 0 010-64h452z"
                ></path>
            </svg>
        </div>
        <!-- <el-button type="primary" @click="addImage()" style="margin-top : 4em; margin-left : 1em">Add Photo</el-button> -->

        <div class="card thumbnail-card" v-show="isThumbnailVisible">
            <img src="" alt="thumbnail" id="thumbnail" />

            <label class="success-label" v-show="isSuccessLabelVisible"
                ><i class="success-icon"
                    ><svg
                        class="icon"
                        width="12"
                        height="12"
                        viewBox="0 0 1024 1024"
                        xmlns="http://www.w3.org/2000/svg"
                    >
                        <path
                            fill="white"
                            d="M406.656 706.944L195.84 496.256a32 32 0 10-45.248 45.248l256 256 512-512a32 32 0 00-45.248-45.248L406.592 706.944z"
                        ></path></svg
                ></i>
            </label>

            <!-- 图标 -->
            <div class="thumbnail-actions">
                <span class="thumbnail-preview" @click="handleThumbnailPreview">
                    <svg
                        class="icon"
                        width="20"
                        height="20"
                        viewBox="0 0 1024 1024"
                        xmlns="http://www.w3.org/2000/svg"
                    >
                        <path
                            fill="white"
                            d="M795.904 750.72l124.992 124.928a32 32 0 01-45.248 45.248L750.656 795.904a416 416 0 1145.248-45.248zM480 832a352 352 0 100-704 352 352 0 000 704zm-32-384v-96a32 32 0 0164 0v96h96a32 32 0 010 64h-96v96a32 32 0 01-64 0v-96h-96a32 32 0 010-64h96z"
                        ></path>
                    </svg>
                </span>

                <span class="thumbnail-delete" @click="handleThumbnailRemove">
                    <svg
                        class="icon"
                        width="20"
                        height="20"
                        viewBox="0 0 1024 1024"
                        xmlns="http://www.w3.org/2000/svg"
                    >
                        <path
                            fill="white"
                            d="M160 256H96a32 32 0 010-64h356V95.936a32 32 0 0132-32h356a32 32 0 0132 32V192h356a32 32 0 110 64h-64v672a32 32 0 01-32 32H192a32 32 0 01-32-32V256zm448-64v-64H416v64h292zM224 896h676V256H224v640zm192-128a32 32 0 01-32-32V416a32 32 0 0164 0v320a32 32 0 01-32 32zm192 0a32 32 0 01-32-32V416a32 32 0 0164 0v320a32 32 0 01-32 32z"
                        ></path>
                    </svg>
                </span>
            </div>

            <!-- 进度条 -->
            <el-progress
                type="circle"
                :percentage="progress"
                v-show="isProgressVisible"
                :width="110"
                id="progress"
            />

            <el-button type="primary" @click="addImage()" style="margin-top : 4em; margin-left : 1em">Add Photo</el-button>
        </div>

        <vue-easy-lightbox
            moveDisabled
            :visible="isLightBoxVisible"
            :imgs="localImageUrl"
            :index="index"
            @hide="handleLightboxHide"
        />
    </div>
</template>

<script>
import { ref, computed } from "vue";
import api from "../api/index";
import { Plus } from "@element-plus/icons-vue";
import VueEasyLightbox from "vue-easy-lightbox";
import path from '../api/path';

export default {
    name: "KilaKilaUploader",
    emits: ["uploaded", "aboutToUpload", "removed"],
    components: { Plus, VueEasyLightbox },
    setup(props, context) {
        let progress = ref(0);
        let isLightBoxVisible = ref(false);
        let isProgressVisible = ref(false);
        let isSuccessLabelVisible = ref(false);
        let imageUrl = ref("");
        let localImageUrl = ref("");
        let index = ref(0);

        let isThumbnailVisible = computed(() => localImageUrl.value.length > 0);

        function openFileDialog() {
            document.getElementById("file-input").click();
        }

        function addImage() {
            document.getElementById("file-input").click();
        }

        function onImageAdded() {
            let fileInput = document.getElementById("file-input");
            if (fileInput.files.length == 0) {
                return;
            }

            context.emit("aboutToUpload");
            let file = fileInput.files[0];
            setImageUrl(URL.createObjectURL(file));
            console.log(URL.createObjectURL(file))
            upload(file);
        }

        function setImageUrl(url) {
            let thumbnailEl = document.getElementById("thumbnail");
            thumbnailEl.src = localImageUrl.value = url;
        }

        function handleThumbnailRemove(file) {
            imageUrl.value = "";
            localImageUrl.value = "";
            context.emit("removed", file);
        }

        function handleThumbnailPreview() {
            isLightBoxVisible.value = true;
        }

        function handleLightboxHide() {
            isLightBoxVisible.value = false;
        }

        function upload(file) {
            progress.value = 0;
            isProgressVisible.value = true;
            isSuccessLabelVisible.value = false;
            var baseUrl = path.baseUrl

            api.uploadImage(file, progress).then(
                (res) => {
                    // console.log(res)
                    // progress.value = 100;
                    // imageUrl.value = res.data.data.url;
                    // var requiredUrl = res.data.data.url
                    // console.log("upload success the url is " + requiredUrl)
                    // // document.getElementById("thumbnail").src = requiredUrl;
                    // context.emit("uploaded", res.data.data.url);
                    // setTimeout(() => {
                    //     isProgressVisible.value = false;
                    //     isSuccessLabelVisible.value = true;
                    // }, 200);
                    // ElMessage({
                    //     message: 'Image uploaded',
                    //     type: 'success',
                    // })

                    console.log(res)
                    if(res.data.status == 200){
                         progress.value = 100;
                        imageUrl.value = res.data.data;
                        var requiredUrl = imageUrl.value 
                        console.log("upload success the url is " + requiredUrl)
                        // document.getElementById("thumbnail").src = requiredUrl;
                        context.emit("uploaded", imageUrl.value);
                        setTimeout(() => {
                            isProgressVisible.value = false;
                            isSuccessLabelVisible.value = true;
                        }, 200);
                        // ElMessage({
                        //     message: 'Image uploaded',
                        //     type: 'success',
                        // })
                        ElNotification({
                            title: 'Success',
                            message: 'Image uploaded',
                            type: 'success',
                        })
                    } else {
                        ElNotification({
                        title: 'Error',
                        message: "Oops, image size exceeds its maximum permitted size of 1MB",
                        type: 'error',
                    })
                    }
                   
                },
                (res) => {
                    console.log(res)
                    isProgressVisible.value = false;
                    localImageUrl.value = "";
                    context.emit("uploaded", "");
                    // ElMessage.error("Oops, uploaded failed")
                    if(res.response.status == 500){
                        ElNotification({
                            title: 'Error',
                            message: "Oops, image size exceeds its maximum permitted size of 1MB",
                            type: 'error',
                        })
                    } else {
                        ElNotification({
                            title: 'Error',
                            message: "Oops, upload failed",
                            type: 'error',
                        })
                    }

                }
            );
        }

        return {
            progress,
            imageUrl,
            localImageUrl,
            index,
            isLightBoxVisible,
            isThumbnailVisible,
            isProgressVisible,
            isSuccessLabelVisible,
            handleThumbnailRemove,
            handleThumbnailPreview,
            handleLightboxHide,
            openFileDialog,
            onImageAdded,
            setImageUrl,
            addImage,
        };
    },
};
</script>

<style scoped>
.uploader {
    display: flex;
  }
  .card {
    background-color: #fbfdff;
    border: 1px dashed #c0ccda;
    border-radius: 6px;
    width: 148px;
    height: 148px;
    overflow: hidden;
  }
  .upload-card {
    display: flex;
    justify-content: center;
    align-items: center;
    transition: all 0.3s;
    cursor: pointer;
  }
  .upload-card:hover {
    border-color: #409eff;
    color: #409eff;
  }
  .thumbnail-card {
    border: 1px solid #c0ccda;
    position: relative;
  }
  .thumbnail-card #thumbnail {
    width: 100%;
    height: 100%;
    object-fit: contain;
    display: inline;
  }
  .thumbnail-card .success-label {
    position: absolute;
    right: -15px;
    top: -6px;
    width: 40px;
    height: 24px;
    background: #67c23a;
    text-align: center;
    transform: rotate(45deg);
    box-shadow: 0 0 1pc 1px #0003;
  }
  .thumbnail-card .success-label .success-icon {
    position: absolute;
    left: 13px;
    top: 1px;
    transform: rotate(-45deg);
  }
  .thumbnail-card #progress {
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    background: rgba(255, 255, 255, 0.7);
  }
  .thumbnail-card #progress :deep(.el-progress-circle) {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  }
  .thumbnail-card .thumbnail-actions {
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.5);
    opacity: 0;
    transition: all 0.4s ease;
    display: flex;
    justify-content: center;
    align-items: center;
    position: absolute;
    top: 0;
    left: 0;
    border-radius: 6px;
  }
  .thumbnail-card .thumbnail-actions .thumbnail-preview,
  .thumbnail-card .thumbnail-actions .thumbnail-delete {
    cursor: pointer;
    margin: 0 8px;
    display: inline-block;
  }
  .thumbnail-card .thumbnail-actions:hover {
    opacity: 1;
  }
  :deep(.vel-img) {
    box-shadow: 0 5px 20px 2px rgba(0, 0, 0, 0.35);
  }
</style>