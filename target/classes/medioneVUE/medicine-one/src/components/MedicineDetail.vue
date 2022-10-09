<template>
	<div class="overall_content">
		<div class = "brief_description">
			<div class = "brief_description_content">
				<div class = "name_picture" v-if="isDataReady">
					<h3>{{ this.mediInfo.brandname }} </h3>
          <img class="medi_photo" :src="imageBasePath + mediInfo.image">
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
							<td class="static_text">Manufacturer Name:</td>
							<td class="db_text"> {{ this.mediInfo.manufacturername}}</td>
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
							<td class="db_text">{{ this.mediInfo.quantity}}</td>
						</tr>
						<tr>
							<td class="static_text">Validity:</td>
							<td class="db_text">{{ this.mediInfo.validity}}</td>
						</tr>
					</table>
				</div>

				<div class ="button_area" v-if="isDataReady">
					<el-row class="button_setting">
						<el-button class="medi_button" type="info" plain :round="true" size="small" @click="openDialog">
						<el-icon><Bell /></el-icon> &nbsp;Take Medicine
						</el-button>
  				</el-row>
					<el-row class="button_setting">
						<el-button class="medi_button" type="info" plain :round = "true" size="small">
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
		
		<div class="dialog_area">
			<el-dialog v-model="dialogFormVisible" title="Take Medicine" center="true" align-center>
				<el-form :model="tableForm">
					<el-form-item label="Amount" :label-width="formLabelWidth">
						<el-input v-model="tableForm.amount" autocomplete="off" />&nbsp&nbsp pills
					</el-form-item>
				</el-form>
				<template #footer>
					<span class="dialog-footer">
						<el-button @click="dialogFormVisible = false">Cancel</el-button>
						<el-button type="primary" @click="dialogFormVisible = false"
							>Confirm</el-button
						>
					</span>
				</template>
			</el-dialog>
		</div>

	</div>


</template>

<script>
import EditNote from "./EditNote.vue";
import DetailDescription from "./DetailDescription.vue";
import api from "../api/index";



export default {
	data () {
		return{
			mediInfo : null,
			isDataReady : false,
			imageBasePath : "https://medione.herokuapp.com/",
			userNote : "",
      dialogFormVisible: false,
			tableForm :{
				amount : "",
			}
		}
	},
	props : {
		mediId : {
			type : Number,
			default : -1,
		}
	},
	components: {
    EditNote,
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
			// console.log(that.userNote)
			console.log(res.data)
		})
		},
		openDialog(){
			this.dialogFormVisible = true
			console.log(this.dialogFormVisible)
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


	.el-dialog{
  display: flex;
  display: -ms-flex; /* 兼容IE */
  flex-direction: column;
  -ms-flex-direction: column; /* 兼容IE */
  margin:0 !important;
  position:absolute;
  top:50%;
  left:50%;
  transform:translate(-50%,-50%);
  max-height:calc(100% - 30px);
  max-width:calc(100% - 30px);
	}
	.el-dialog .el-dialog__body{
		max-height: 100%;
		flex: 1;
		-ms-flex: 1 1 auto; /* 兼容IE */
		overflow-y: auto;
		overflow-x: hidden;
	}

	.el-dialog__wrapper {
		/*隐藏ie和edge中遮罩的滚动条*/
		overflow: hidden;
	}
	.el-input {
		width: 5em;
	}
}


</style>