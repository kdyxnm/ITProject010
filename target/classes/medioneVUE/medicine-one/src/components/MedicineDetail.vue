<template>
	<div class="overall_content">
		<div class = "brief_description">
			<div class = "brief_description_content">
				<div class = "name_picture" v-if="isDataReady">
					<!-- <h2>{{ this.mediInfo.brandname }} </h2> -->
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
						<el-button type="info" plain :round="true" size="small">
						<el-icon><Bell /></el-icon> &nbsp;Take Medicine
						</el-button>
						
  				</el-row>
					<!-- <el-row class="button_setting">
						<el-button type="info" plain :round = "true" size="small">
						<el-icon><Document /></el-icon> &nbsp;View  Notes
						</el-button>
  				</el-row> -->
					<el-row class="button_setting">
						<el-button type="info" plain :round = "true" size="small">
						<el-icon><DeleteFilled /></el-icon> &nbsp;Delete Medicine
						</el-button>
  				</el-row>
					<el-row class="button_setting">
						<el-button type="info" plain :round = "true" size="small">
						<el-icon><EditPen /></el-icon> &nbsp;Modify Drug Description
						</el-button>
  				</el-row>
				</div>

			</div>
		</div>

		<div class = "components" v-if="isDataReady" >
			<div class = "edit_note">
				<EditNote :userNote="'Have taken this medicine. 2022/9/25'"></EditNote>
			</div>

			<div class = "detailed_description">
				<DetailDescription :detailInfo="this.mediInfo"></DetailDescription>
				<!-- <MedicineDetail :mediId="this.mediInfoId" ></MedicineDetail> -->
			</div>
		</div>
	</div>


</template>

<script>
import EditNote from "./EditNote.vue";
import DetailDescription from "./DetailDescription.vue";
import api from "../api/index"
export default {
	data () {
		return{
			mediInfo : null,
			isDataReady : false,
			imageBasePath : "https://medione.herokuapp.com/",
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
		DetailDescription
	},
	created(){
		var that = this
		console.log(this.mediId)
		api.getMediInfo(this.mediId).then(res=>{
			that.mediInfo = res.data.data
			console.log(that.mediInfo)
			that.isDataReady = true;
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
  overall_content{
    width: 100%;
    padding: 2em;
  }
	h2 {
		font-size: 1.5em;
	}
	.components {
		width: 100%;
	}

	.detailed_description {
		margin-top: 2em;
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

	.el-button {
		width: 18em;
		font-size: 1em;
		color: #626aef;
	}
}

/* screen size */
@media screen and (min-width: 992px){   
  overall_content{
    width: 100%;
  }
	/* .overall_content {
		width: 100%;
	} */

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
		margin-top: 2em;
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

	h2 {
		margin-left: 2em;
		margin-bottom: 0em;
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

	.button_setting {
		margin-top: 0.5em;
		padding: 0.5em;
	}

	.el-button {
		width: 15em;
		font-size: 0.9em;
	}
}


</style>