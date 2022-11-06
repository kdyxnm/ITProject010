<template>
	<div class="container">
		<HeadBar :header="headerTitle" :btnStyle="headerStyle" class="phone_only" @open-side-bar-event="openSideBar"></HeadBar>

			<!--head bar phone only-->
		<div class="center_bar content_container" style="margin-left: 0;">
			<h3 class="desk_top_only">Reset Password</h3>
			<button @click="backToPrev" class="return_button desktop_only">
				<el-icon :size=30 color="#6E78F7"><Back /></el-icon>
			</button>
			<table class="center_bar_content">
				<tr class="center_bar_label">
					<label class="center_bar_title">Email:</label>
				</tr>
				<tr>
					<p><input type="text" v-model.trim ="email" class="input_area"></p>
				</tr>
				
				<tr class="center_bar_label">
					<label class="center_bar_title">Verification Code:</label>
				</tr>
				<tr>
					<p><input type="string" v-model.trim ="code" class="input_area"></p>
				</tr>
				<tr class="center_bar_label">
					<label class="center_bar_title">Set Password:</label>
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
				<tr>
					<p><input type="button" class="purple_button" value = "Send Verify Code" @click="verifyButton"></p>
				</tr>
				<tr>
					<p><input type="submit" value="Confirm" class="purple_button" @click= "resetPassword"></p>
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
    name: 'RegisterView',
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
				const loading = this.openFullScreen2();
				api.emailVerify(that.userName, that.email).then(function(response){
					loading.close()
					if (response.data.status == 200) {
						console.log(response.data)
						ElNotification({
							message: 'Verify code send out',
							type: 'success',
							duration: 5000,
						}) 
					} else {
						ElNotification({
							message: 'Invalid email',
							type: 'error',
							duration: 5000,
						})
					}  
				})
			},
			backToPrev(){
				this.$router.back(-1)
			},
			confirmButton(){
				this.isEmpty()
			},
			resetPassword(){		
        var that=this;
				if(that.email.length < 1||that.code.length < 1||that.pwd.length < 1||that.pwdRepeat.length < 1){
					ElNotification({
            message: 'You must complete all information!',
            type: 'warning',
						duration: 5000,
          })
				} else if (that.pwd.length <= 7) {
					ElNotification({
						message: 'The password must be at least 8 characters!',
						type: 'warning',
						duration: 5000,
					})
				} else if (that.pwd != that.pwdRepeat) {
					ElNotification({
						message: 'The two password are inconsistent!',
						type: 'warning',
						duration: 5000,
					})
				} else {
					const loading = this.openFullScreen2();
					api.resetPassward(that.email, that.code, that.pwd).then(function(response){
					loading.close()
					if(response.data.status == 200){
            that.$router.push({path : '/'})
						ElNotification({
							message: 'Success!',
							type: 'success',
							duration: 5000,
						})
          }
          else{
            that.errorMessage = response.data.msg
						ElNotification({
							message: that.errorMessage,
							type: 'error',
							duration: 5000,
						})
          }
				})
				}
   		},
			openFullScreen2(){
				const loading = ElLoading.service({
					lock: true,
					text: 'Loading',
					background: 'rgba(0, 0, 0, 0.7)',
				})
				// setTimeout(() => {
				//   loading.close()
				// }, 10000)
				return loading
			},
    },

    mounted() {
      this.displayDeskOnly = (window.innerWidth > 992)
    }
 }

</script>

<style scoped src="../assets/library/css/background_and_center_bar.css"></style>
<style scoped src="../assets/library/css/desktop_base_format.css"></style>
<style scoped src="../assets/library/css/phone_base_format.css"></style>
<style scoped>
@media screen and (min-width: 992px) {
	.center_bar {
		width: 37%;
	}
	.desk_top_only {
		font-size: 2.2em;
		margin-bottom: -0.7em;
	}
	.return_button {
		top: -1.5em;
	}
	.input_area {
		margin-left: -0.5em;
	}

}

</style>
