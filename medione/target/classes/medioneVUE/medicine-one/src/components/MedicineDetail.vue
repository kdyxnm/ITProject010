<template>
	<div class="overall_content">
		<div class = "brief_description">
			<div class = "brief_description_content">
				<div class = "name_picture">
					<h2>Norvasc</h2>
				</div>
				<div class = "medicineinfo">
					<table class ="medicineinfo_table">
						<tr><p id="header">Brief Discription</p></tr>
						<tr>
							<td class="static_text">Brand Name:</td>
							<td class="db_text">Norvasc</td>
						</tr>
						<tr>
							<td class="static_text">Generic Name:</td>
							<td class="db_text">Amlodipine Besylate</td>
						</tr>
						<tr>
							<td class="static_text">Manufacturer Name:</td>
							<td class="db_text"> Pfizer Laboratories Div Pfizer Inc</td>
						</tr>
						<tr>
							<td class="static_text">Product Type:</td>
							<td class="db_text">Human Prescription Drug</td>
						</tr>
						<tr>
							<td class="static_text">Route:</td>
							<td class="db_text">Oral</td>
						</tr>
						<tr>
							<td class="static_text">Quantity:</td>
							<td class="db_text">3 package</td>
						</tr>
						<tr>
							<td class="static_text">Validity:</td>
							<td class="db_text">03/08/2022</td>
						</tr>
					</table>
				</div>

				<div class ="button_area">
					<el-row class="button_setting">
						<el-button type="info" plain :round="true" size="small">
						<el-icon><Bell /></el-icon> &nbsp;Take Medicine
						</el-button>
						
  				</el-row>
					<el-row class="button_setting">
						<el-button type="info" plain :round = "true" size="small">
						<el-icon><Document /></el-icon> &nbsp;View  Notes
						</el-button>
  				</el-row>
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

		<div class = "components">
			<div class = "edit_note">
				<EditNote></EditNote>
			</div>

			<div class = "detailed_description">
				<DetailDescription></DetailDescription>
			</div>

		</div>
	</div>


</template>

<script>
import EditNote from "./EditNote.vue";
import  DetailDescription from "./EditNote.vue";
export default {
    components: {
			 EditNote, 
			 DetailDescription
			}
}
</script>

<style>
	.overall_content {
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
		margin: 0%;
	}

	.medicineinfo {
		width: 50%;
	}

	.button_area{
		width: 25%;
	}

	.medicineinfo_table {
		font-size: 0.7em;
		margin-top: -0.3em;
		margin-bottom: 1.5em;
	}

	#header {
		font-size: large;
		margin: 0.2em 0em;
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


</style>