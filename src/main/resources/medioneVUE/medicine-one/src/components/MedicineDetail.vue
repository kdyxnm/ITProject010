<template>
	<div class="overall_content">
		<div class = "brief_description">
			<div class = "brief_description_content">
				<div class = "name_picture" v-if="isDataReady">
					<h3>{{ this.mediInfo.brandname }} </h3>
          <img class="medi_photo" :src="mediInfo.image">
				</div>
				<div class = "medicineinfo" v-if="isDataReady">
					<table class ="medicineinfo_table">
						<tr><p id="header">Brief Discription</p></tr>
						<tr>
							<td class="static_text">Brand Name:</td>
							<td class="db_text">{{ this.mediInfo.brandname }}</td>
						</tr>
						<tr>
							<td class="static_text">Generic Name:</td>
							<td class="db_text">{{ this.mediInfo.genericname}}</td>
						</tr>
						<tr>
							<td class="static_text">Product Type:</td>
							<td class="db_text">{{this.mediInfo.producttype}}</td>
						</tr>
						<tr>
							<td class="static_text">Route:</td>
							<td class="db_text">{{ this.mediInfo.route}}</td>
						</tr>
						<tr>
							<td class="static_text">Quantity:</td>
							<td class="db_text">{{ this.mediInfo.quantity}} {{this.mediInfo.quantitytype}}</td>
						</tr>
						<tr>
							<td class="static_text">Validity:</td>
							<td class="db_text">{{ this.mediInfo.validity}}</td>
						</tr>						<tr>
							<td class="static_text">Location:</td>
							<td class="db_text">{{ this.mediInfo.location}}</td>
						</tr>
					</table>
				</div>

				<div class ="button_area" v-if="isDataReady">
					<el-row class="button_setting">
						<el-button class="medi_button" type="info" plain :round="true" size="small" @click="openDialog1">
						<el-icon><Bell /></el-icon> &nbsp;Finish Medicine
						</el-button>
  				</el-row>
					<el-row class="button_setting">
						<el-button class="medi_button" type="info" plain :round = "true" size="small" @click="openDialog2">
						<el-icon><DeleteFilled /></el-icon> &nbsp;Delete Medicine
						</el-button>
  				</el-row>
				</div>

			</div>
		</div>

		<div class = "components" v-if="isDataReady" >
			<div class = "edit_note">
				<div class="overall_notepart">
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
						<input type="button" class="submitNote_button" value="Update Note" @click="noteButton">
						<!-- <el-button type="button" plain @click="submit_note">Update</el-button> -->
					</div>
				</div>
				</div>
			</div>

			<div class = "detailed_description">
				<DetailDescription :detailInfo="this.mediInfo"></DetailDescription>
			</div>
		</div>
		<!-- take medicine dialog -->
		<div class="dialog_area">
			<el-dialog
				v-model="dialogFormVisible1"
				title="Warning"
				width="60%"
				align-center
				center
			>
				<span class="warning_text">Are you sure you have finished this medicine?</span>
				<template #footer>
					<span class="dialog-footer">
						<el-button @click="dialogFormVisible1 = false">Cancel</el-button>
						<el-button type="primary" @click="takeConfirmButon"
							>Confirm</el-button
						>
					</span>
				</template>
			</el-dialog>
			<!-- delete medicine dialog-->
			<el-dialog
				v-model="dialogFormVisible2"
				title="Warning"
				width="60%"
				align-center
				center
			>
				<span class="warning_text">This will delete all data about this kind of drug! Please  consider carefully!</span>
				<template #footer>
					<span class="dialog-footer">
						<el-button @click="dialogFormVisible2 = false">Cancel</el-button>
						<el-button type="primary" @click="deleteConfirmButon"
							>Confirm</el-button
						>
					</span>
				</template>
			</el-dialog>
		</div>

	</div>


</template>

<script>
import DetailDescription from "./DetailDescription.vue";
import api from "../api/index";
import { nextTick } from '@vue/runtime-core';



export default {
	data () {
		return{
			mediInfo : null,
			isDataReady : false,
			imageBasePath : "https://medione.herokuapp.com/",
			userNote : "",
      dialogFormVisible1: false,
			dialogFormVisible2: false,
			amount: "1",
		}
	},
	props : {
		mediId : {
			type : Number,
			default : -1,
		}
	},
	components: {
    DetailDescription,
},
	methods: {
		noteButton(){
			var that=this;
			this.addNote()
			console.log(that.userNote)
		},
		addNote() {
			var that=this;
			api.addMediNote(this.mediId, that.userNote).then(res=>{
			if(res.data.status == 200) {
					ElMessage({
            message: 'Update successful!',
            type: 'success',
          })
				} else if(res.data.status == 404) {
					ElMessage({
            message: 'Update failed',
            type: 'error',
          })
					}
		})
		},
		openDialog1() {
			this.dialogFormVisible1 = true;
		},
		openDialog2() {
			this.dialogFormVisible2 = true
			console.log(this.dialogFormVisible2)
		},
		takeConfirmButon() {
			var that=this;
			api.takeMedicine(that.mediId, that.amount).then(res=>{
				console.log(res.data);
				that.dialogFormVisible1 = false;
				if(res.data.status == 200) {
					console.log(res.data.status)
					ElNotification({
            message: 'Update successful, please refresh!',
            type: 'success',
          })
					console.log(res.data.status)
				} else if(res.data.status == 404) {
					ElNotification({
            message: 'Update failed! Quantity: 0',
            type: 'error',
          })
					}
			})
		},
		deleteConfirmButon() {
			var that=this;
			api.deleteMedicine(that.mediId).then(res=>{
				console.log(res.data);
				that.dialogFormVisible1 = false;
				if(res.data.status == 200){
					this.triggerUpdate()
					ElNotification({
            message: 'Update successful!',
            type: 'success',
          }) 
				} else if(res.data.status == 404) {
					ElNotification({
            message: 'Update failed!',
            type: 'error',
          })
					}
		})
		},
		triggerUpdate(){
			console.log("Update medidata")
			this.$emit("medicine-updated")
			this.backToPrev()
		},
		backToPrev(){
			var mode = {
				view : 'default',
			}
			this.$emit("switch-event", mode)
		}
	},
	created(){
		var that = this
		console.log(this.mediId)
		api.getMediInfo(this.mediId).then(res=>{
			that.mediInfo = res.data.data
			console.log(that.mediInfo)
			that.isDataReady = true;
		})
		api.getMediNote(this.mediId).then(res=>{
			that.userNote = res.data.data.note
			console.log(res.data)
		})
	},


	mounted() {
		// var that = this
		// console.log(this.mediId)
		// api.getMediInfo(this.mediId).then(res=>{
		// 	that.mediInfo = res.data.data
		// })
	},
}
</script>

<style scoped>
/* phone size */
@media screen and (max-width: 992px){   
  .overall_content{
    width: 100%;
  }
	h2 {
		font-size: 1.5em;
	}
	.components {
		width: 100%;
	}

	.detailed_description {
		margin-top: 1em;
	}
	
	.edit_note {
		margin-top: 2em;
	}

	.brief_description {
		height: 40%;
		background-color: #E5E9FD;
		border-radius: 1.5em;
	}

	.brief_description_content {
		margin: 1em;
		padding-bottom: 0.5em;
		height: 100%;
	}

	#header {
		font-weight: bold;
	}

	.name_picture {
		width: 100%;
	}

	h3 {
		margin-bottom: 0em;
	}

	.medi_photo{
    width: 7em;
    height: 7em;
		margin: 1em 6.5em;
  }

	.medicineinfo_table {
		font-size: 0.7em;
		margin-top: -1em;
		margin-bottom: 1em;
	}

	.static_text {
		padding-right: 2em;
		padding-bottom: 0.7em;
	}

	.button_area {
		width: 100%;
	}
	
	.button_setting {
		margin: 0em 1em;
		padding: 0.1em;
	}

	.medi_button {
		width: 18em;
		font-size: 1em;
		color: #626aef;
	}


  .el-id-4110-2 {
    min-height: 100px;
  }

  .submitNote_button {
		height: 1.5em;
		width: 7em;
		border-radius:0.5em;
		border-style: none;
		background: #5A7BEF;
    color: white;
		font-size: 16px;
    font-weight: 400;
		margin-top: 0.7em;
    /* margin-bottom: 1em; */
    margin-left: 14em;
  }

	.el-input {
		width: 5em;
	}

	.warning_text {
		word-break: normal;
	}

}

/* screen size */
@media screen and (min-width: 992px){   
  .overall_content{
    width: 100%;
  }

	.components {
		width: 100%;
		display: flex;
	}

	.detailed_description {
		width: 50%;
		margin-top: 2em;
	}

	.edit_note {
		width: 50%;
		margin-right: 2em;
		margin-top: 1em;
	}

	.brief_description {
		width: 100%;
		height: 40%;
		background-color: #E5E9FD;
	}

	.brief_description_content {
		display: flex;
		margin: 0%;
		height: 100%;
	}

	.name_picture {
		width: 25%;
	}

	h3 {
		margin-left: 2em;
		margin-bottom: 0em;
		margin-right: 1em;
	}

	.medi_photo {
		width: 8em;
		height: 8em;
		margin: 1em 2em;
  }

	.medicineinfo {
		width: 50%;
	}

	.button_area{
		width: 25%;
	}
	
	#header {
		font-size: large;
		margin: 1em 0em;
	}

	.medicineinfo_table {
		font-size: 0.7em;
		margin-top: -0.3em;
		margin-bottom: 1.5em;
	}

	.static_text {
		padding-right: 10em;
	}

	.button_area {
		margin-top: 3em;
	}

	.button_setting {
		margin-top: 0.5em;
		padding: 1em;
	}

	.el-button {
		width: 15em;
		height: 2.5em;
		font-size: 0.9em;
	}

	.submit_button {
		margin-left: 0em;
	}
	
  .submitNote_button {
		height: 2em;
		width: 8em;
		border-radius:0.5em;
		border-style: none;
		background: #5A7BEF;
    color: white;
		font-size: 16px;
    font-weight: 400;
		margin-top: 0.7em;
    /* margin-bottom: 1em; */
    /* margin-left: 1em; */
  }

	.el-input {
		width: 5em;
	}
	.warning_text {
		word-break: normal;
	}

}


</style>