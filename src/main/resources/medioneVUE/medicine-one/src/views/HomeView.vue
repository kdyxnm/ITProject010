<template>
  <div class="container">
    <div class = "website_header phone_only">
      <button class="open_button"
      @click="openSideBar">
      ☰
      </button>
      <h1 class = "website_title">
        Medicine One
      </h1>
    </div>
    <SideBar @close-side-bar-event="closeSideBar" v-show="displayFlag" ref="ChildSideBar"></SideBar>
    <!-- The side bar of the website -->
    <div class="center_bar content_container" style="margin-left: 0;">

      <h3 class="desktop_only">Medicine One</h3>

      <h4 class="desktop_only"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; by Team 010</h4>

      <table class="center_bar_content">
        <tr class="center_bar_label"><label class="center_bar_title">User Name</label></tr>
        <tr><input v-model.trim="userName" type="text" class="input_area"></tr>

        <tr class="center_bar_label"><label class="center_bar_title">Password</label></tr>
        <tr><input v-model.trim="pwd" type="password" class="input_area"></tr>
        <tr style="text-align:right">
          <router-link to="/resetPassword">
            <a id="forget_pwd" >Forget Password?</a>
          </router-link>
        </tr>
        <tr><p class = "warning">{{ warningText }}</p></tr>
        <tr><input type="submit" name="login" 
            value="Login" class="purple_button" @click="handleLogin"></tr>
        <tr>
          <router-link to="/register">
            <div class = "purple_button" style="display: inline-block">
              <p style="margin-top:0.2em">Register</p>
            </div>
          </router-link>
        </tr>
        <tr>
          <router-link v-if="displayDeskOnly" to="/about">
            <div class = "purple_button" style="display: inline-block">
              <p style="margin-top:0.2em">About Medicine One</p>
            </div>
          </router-link>
        </tr>


      </table>


    </div>
  </div>
</template>

<script>
import SideBar from '../components/SideBar.vue';
import api from '../api/index';
// import store from '../store/index';


  export default {
    name: 'HomeView',
    data() {
      return {
        displayFlag : false,
        displayDeskOnly: true,
        warningText : "",
        userName : "",
        pwd : "",


      }
    },
    components: {
      SideBar,
    },
    methods: {
      openSideBar(){
        this.displayFlag = true;
      },
      closeSideBar(){
        this.displayFlag = false;
      },
      handleLogin(){
        this.verifyUser()
      },
      verifyUser(){
        var that=this;
        console.log(that.userName);
        console.log(that.pwd.length > 0 ? "password entered" : "Password is empty");
        const loading = this.openFullScreen2();
        
        api.login(that.userName, that.pwd).then(function(response){
          console.log(response.data.data);
          console.log(response)
          loading.close()
          if(response.data.status == 200){
            that.$store.commit("authenticate");
            that.$router.push({path : '/dashboard/' + response.data.data.username})
          }
          else{
            that.warningText = "Incorrect username or password, please try again"
          }
        })

        console.log("Auth flag " + that.$store.getters.isAuthenticated)
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
      }
    },
    mounted() {
      this.displayDeskOnly = (window.innerWidth > 992)
    }
  }

</script>


<style scoped src="../assets/library/css/desktop_base_format.css"></style>
<style scoped src="../assets/library/css/phone_base_format.css"></style>
<style scoped src="../assets/library/css/background_and_center_bar.css"></style>
<style scoped src="../assets/library/css/login.css"></style>
