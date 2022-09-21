<template>
	<div class="container">
		<HeadBar :header="headerTitle" :btnStyle="headerStyle" class="phone_only" @open-side-bar-event="openSideBar"></HeadBar>

			<!--head bar phone only-->
		<div class="center_bar content_container" style="margin-left: 0;">
			<h3 class="desk_top_only" style="font-size : 2em;">Reset Password</h3>
			<button @click="backToPrev" class="return_button desktop_only">
				<el-icon :size=30 color='#6E78F7'><Back /></el-icon>
			</button>
			<table class="center_bar_content">
				<tr class="center_bar_label">
					<label class="center_bar_title">Email:</label>
				</tr>
				<tr>
					<input type="text" v-model.trim ="email" class="input_area">
				</tr>

				<tr class="center_bar_label">
					<label class="center_bar_title">Verification Code:</label>
				</tr>
				<tr>
					<p><input type="number" v-model.trim ="code" class="input_area"></p>
				</tr>
				<tr>
					<p><input type="button" class="purple_button" value = "Send Verify Code" @click="verifyButton"></p>
				</tr>

				<tr class="center_bar_label">
					<label class="center_bar_title">New Password:</label>
				</tr>
				<tr>
					<p><input type="password"  v-model.trim ="pwd" class="input_area"></p>
					<p class="warning" v-if="iswarning"> {{warningText}} </p>
				</tr>

				<tr class="center_bar_label">
					<label class="center_bar_title">Confirm New Password:</label>
				</tr>
				<tr>					
					<p><input type="password"  v-model.trim ="pwdRepeat" class="input_area"></p>
				</tr>
				
				<!-- <tr>
					<p><input type="button" class="purple_button phone_only" value= "Verify Email" @click="verifyButton"></p>
				</tr> -->


				<!-- <tr>
					<el-icon id='tick'><Select /></el-icon>
				</tr> -->
				<tr>
					<p><input type="submit" value="Confirm" class="purple_button" @click= "confirmButton"></p>
				</tr>
				

			</table>
			<!--Form send the user input register information to back end-->

			</div>
		<!--center bar-->
	</div>    
</template>

<script>
import HeadBar from '../components/HeadBar.vue';
import api from '../api/index';

  export default {
    name: 'ResetPasswordView',
    data() {
      return {
        // displayFlag : false,
        // displayDeskOnly: true,
				iswarning: false,
				errorMessage : "",
        warningText : "",
        email : "",
				code : "",
        pwd : "",
				pwdRepeat : "",
				headerTitle : "Reset Password",
				headerStyle : "Return",
      }
    },
    components: {
			HeadBar
    },
    methods: {
      verifyButton(){
				this.verifyCode()
      },
			verifyCode(){
				var that=this;
				console.log(this.code)
				api.emailVerify(that.userName, that.email).then(function(response){
					console.log(response.data)  
				})
			},
			backToPrev(){
				this.$router.back(-1)
			},

			confirmButton(){
				this.isEmpty()
			},
			isEmpty(){
				var that=this;
				if(that.email.length < 1||that.code.length < 1||that.userName < 1||that.nickName < 1||that.pwd < 1||that.pwdRepeat < 1){
					that.iswarning = true
					that.warningText = "You must complete all information!"
					console.log(that.warningText)
				}
				else if(that.pwd != that.pwdRepeat){
					that.iswarning = true
					that.warningText = "The two password entries are inconsistent, please enter again"
				}
				else{
					that.iswarning = false
					this.registerUser()
				}
			},
      registerUser(){
        var that=this;
				that.code = that.code.toString()
				console.log(that.code)
        // console.log(this.email);
				console.log(that.pwd.length > 0 ? "password entered" : "Password is empty");
				api.register(that.email, that.code, that.userName, that.nickName, that.pwd).then(function(response){
					console.log(response.data)  
					console.log(typeof that.code)
				})
   		}
    },
    mounted() {
      this.displayDeskOnly = (window.innerWidth > 992)
    }
 }

</script>

<style scoped src="../assets/library/css/background_and_center_bar.css"></style>

<style scoped src="../assets/library/css/desktop_base_format.css"></style>

<style scoped src="../assets/library/css/phone_base_format.css"></style>
