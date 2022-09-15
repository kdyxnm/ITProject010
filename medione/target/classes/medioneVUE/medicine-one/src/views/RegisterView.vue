<template>
	<div class="container">
		<header class = "website_header phone_only" id="login_header">
			<a href="./User_login.html">
				<div class="return_button" style="display: block;">
					
				</div>
			</a>
			<h1 class = "website_title" id="login_website_title">
					Reset Password
			</h1>
		</header>

			<!--head bar phone only-->
		<div class="center_bar content_container">
			<h5 class="title" id="title3">Register</h5>

			<table>
					<router-link v-if="displayDeskOnly" to="/">
					<div class="return_button desktop_only" ></div>
					</router-link>
				<tr>
					<label class="center_bar_title">Email:</label>
				</tr>
				<tr>
					<div id = "emial_input_and_verify">
					<input type="text" v-model.trim ="email" class="input_area">
					<input type="button" class="verify_button desktop_only" value= "Verify Email" @click="verifyButton">
					</div>
				</tr>
				<tr>
					<p><input type="button" class="purple_button phone_only verify_button" value= "Verify Email" @click="verifyButton"></p>
				</tr>
				<tr>
					<label class="center_bar_title">Verification Code:</label>
					<p><input type="text" v-model.trim ="verifyCode" class="input_area"></p>
				</tr>
				<tr>
					<label class="center_bar_title">Username:</label>
					<p><input type="text" v-model.trim ="userName" class="input_area"></p>
				</tr>
				<tr>
					<label class="center_bar_title">Nickname:</label>
					<p><input type="text"  v-model.trim ="nickName" class="input_area"></p>
				</tr>
				<tr>
					<label class="center_bar_title">Set Password:</label>
					<p><input type="password"  v-model.trim ="pwd" class="input_area"></p>
					<p class="notice_words" v-if="iswarning"> {{errorMessage}} </p>
				</tr>
				<tr>					
					<label class="center_bar_title">Confirm New Password:</label>
					<p><input type="password"  v-model.trim ="pwdRepeat" class="input_area"></p>
					<p><input type="submit" value="Confirm" class="purple_button" id="input_submit" @click= "confirmButton"></p>
				</tr>
			</table>
			<!--Form send the user input register information to back end-->

			</div>
		<!--center bar-->
	</div>    
</template>

<script>
import SideBar from '../components/SideBar.vue';
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
      }
    },
    components: {
      SideBar,
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
          url:'/api/user/register',
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

<style scoped>
	@import '../../../../static/css/background_and_center_bar.css';
	@import '../../../../static/css/register_and_reset_pwd.css';
	@import '../../../../static/css/phone_base_format.css';
</style>