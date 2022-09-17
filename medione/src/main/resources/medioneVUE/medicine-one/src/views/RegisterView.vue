registerview.vue

<template>
	<div class="container">
		<HeadBar :header="headerTitle" :btnStyle="headerStyle" class="phone_only" @open-side-bar-event="openSideBar"></HeadBar>

			<!--head bar phone only-->
		<div class="center_bar content_container" style="margin-left: 0;">
			<h3 class="desk_top_only">Register</h3>
			<!-- <router-link v-if="displayDeskOnly" to="/">
			<div class="return_button desktop_only" ></div>
			</router-link> -->
			<table class="center_bar_content">
				<tr class="center_bar_label">
					<label class="center_bar_title">Username:</label>
				</tr>
				<tr>
					<p><input type="text" v-model.trim ="userName" class="input_area"></p>
				</tr>
				
				<tr class="center_bar_label">
					<label class="center_bar_title">Nickname:</label>
				</tr>
				<tr>
					<p><input type="text"  v-model.trim ="nickName" class="input_area"></p>
				</tr>

				<tr class="center_bar_label">
					<label class="center_bar_title">Set Password:</label>
				</tr>
				<tr>
					<p><input type="password"  v-model.trim ="pwd" class="input_area"></p>
					<p class="warning" v-if="iswarning"> {{errorMessage}} </p>
				</tr>

				<tr class="center_bar_label">
					<label class="center_bar_title">Confirm New Password:</label>
				</tr>
				<tr>					
					<p><input type="password"  v-model.trim ="pwdRepeat" class="input_area"></p>
				</tr>
				<tr class="center_bar_label">
					<label class="center_bar_title">Email:</label>
				</tr>
				<tr>
					<input type="text" v-model.trim ="email" class="input_area">
				</tr>
				
				<!-- <tr>
					<p><input type="button" class="purple_button phone_only" value= "Verify Email" @click="verifyButton"></p>
				</tr> -->

				<tr class="center_bar_label">
					<label class="center_bar_title">Verification Code:</label>
				</tr>
				<tr>
					<p><input type="text" v-model.trim ="verifyCode" class="input_area"></p>
				</tr>
				<tr>
					<p><input type="button" class="purple_button" value= "Verify Email" @click="verifyButton"></p>
				</tr>
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



  export default {
    name: 'RegisterView',
    data() {
      return {
        displayFlag : false,
        displayDeskOnly: true,
				iswarning: false,
				errorMessage : "",
        warningText : "Your password has to be at least 8 characters long.",
        email : " ",
				verifyCode : "",
				userName : "",
				nickName : "",
        pwd : "",
				pwdRepeat : "",
				headerTitle : "Register",
				headerStyle : "Return"
      }
    },
    components: {
			HeadBar
    },
    methods: {
      verifyButton(){
      },
			confirmButton(){
        console.log(this.email);
        console.log(this.verifyCode);
				console.log(this.userName);
				console.log(this.nickName);
				console.log(this.pwd);
				console.log(this.pwdRepeat);
        this.registerUser()
			},
      registerUser(){
        var that=this;
        console.log(this.email);
        console.log(this.verifyCode);
				console.log(this.userName);
				console.log(this.nickName);
				console.log(this.pwd);
				console.log(this.pwdRepeat);
				console.log(this.errorMessage);
        this.$axios({
          method:'post',
          url:'http://localhost:8081/api/user/register',
          data: {
						email: that.email,
						code: that.verifyCode,
						username: that.userName.trim(), 
						nickname: that.nickName,
            password: that.pwd,
						iswarning: that.iswarning,
						errorMessage: that.errorMessage
          },
          headers:{
            'Content-Type' : 'application/json'
          }
          }).then(function(response){
						if (response.data.status == 800){
							if (response.data.msg == "USERNAME_EXIST") {
								that.iswarning = true
								that.errorMessage = "This username has already been registered, please change another one!"
								console.log(response.data.msg)
							}
							if (response.data.msg == "EMAIL_EXIST") {
								that.iswarning = true
								that.errorMessage = "This email has already been registered, please change another one!"
								console.log(response.data.msg)
							}
							if (response.data.msg == "CODE_MISMATCH") {
								that.iswarning = true
								that.errorMessage = "This email verification code incorrect, please try again!"
								console.log(response.data.msg)
							}
            console.log(response.data)
						console.log(response.data.status)
						console.log(response.status)
						} else if(response.data.status == 200) {
							that.iswarning = true
							that.errorMessage = "registration success!"
						}  
          });
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
