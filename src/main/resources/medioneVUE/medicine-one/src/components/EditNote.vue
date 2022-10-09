<template>
  <div class="overall_content">
    <!-- <el-skeleton :rows="3" animated /> -->

    <div style="margin: 20px 0" class="input_area">
      <el-input
        v-model="userNote"
        :rows="11"
        maxlength="200"
        placeholder="You can leave a message here"
        show-word-limit
        type="textarea"
      />
      
      <div class="submit_button">
        <!-- <input type="button" class="submitNote_button" value="submit" @click="submit_note"> -->
        <el-button type="button" plain @click="submit_note">Update</el-button>
      </div>

  </div>

  </div>
</template>

<script>
export default {
  data() {
    return {
      

    }
  },
  props : {
    userNote : {
      type : String,
      default : ''
    },
  }


}

</script>

<style scoped>
/* phone size */
@media screen and (max-width: 992px){   
  overall_content{
    width: 100%;
    padding: 2em;
  }

  .el-id-4110-2 {
    min-height: 100px;
  }

  .submit_button {
    margin-left: 17em;
    margin-top: 0.5em;
  }


}

/* screen size */
@media screen and (min-width: 992px){  


  .submit_button {
    margin-left: 28em;
    margin-top: 1em;
  }

}

</style>