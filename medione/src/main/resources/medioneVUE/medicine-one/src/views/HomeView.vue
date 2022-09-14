<template>
  <div class="container">
    <div class = "website_header phone_only">
      <button class="open_button"
      @click="openSideBar">
      ☰
      </button>
      <h1 class = "website_title" id="login_website_title">
        Medicine One
      </h1>
    </div>
    <SideBar @close-side-bar-event="closeSideBar" v-show="displayFlag" ref="ChildSideBar"></SideBar>
    <!-- The side bar of the website -->
    <div class="center_bar2 content_container" style="margin-left: 0;">

      <h3 class="desktop_only">Medicine One</h3>

      <h4 class="desktop_only">by Team 010</h4>

      <table class="center_bar_content">
        <tr class="center_bar_label"><label class="center_bar_title2">User Name</label></tr>
        <tr><input v-model="userName" type="text" class="input_area2"></tr>

        <tr class="center_bar_label"><label class="center_bar_title2">Password</label></tr>
        <tr><input v-model="pwd" type="password" class="input_area2"></tr>
        <tr style="text-align:right"><a id="forget_pwd" href="">Forget Password?</a></tr>
        <tr><p class = "warning">{{ warningText }}</p></tr>
        <tr><input type="submit" name="login" 
            value="Login" class="purple_button" id="login_button" @click="handleLogin"></tr>
        <tr>
          <router-link to="/">
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
import querystring from 'querystring';
import SideBar from '../components/SideBar.vue'


  export default {
    name: 'HomeView',
    data() {
      return {
        displayFlag : false,
        displayDeskOnly: true,
        warningText : "Incorrect username or password, please tray again",
        userName : " ",
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
        console.log(this.userName);
        console.log(this.pwd);
        this.verifyUser()
      },
      verifyUser(){
        var that=this;
        console.log(that.userName);
        console.log(that.pwd);
        this.$axios({
          method:'post',
          url:'http://localhost:8081/user/login',
          data: {
            username:that.userName.trim(),  
            password:that.pwd,
          },
          headers:{
            'Content-Type' : 'application/json'
          }
          }).then(function(response){
              console.log(response.data)
              
          });
      }
    },
    mounted() {
      this.displayDeskOnly = (window.innerWidth > 992)
    }
  }

</script>


<style scoped>
/* import the Poppins font family */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap');

* {
  font-family: "Poppins", sans-serif;
}

a {
  text-decoration: none;
}

.container {
  padding-top: 0;
  margin-top: 0;
  border-top: 0;
  background-color: #F5F5F5;
}

.center_bar_content{
  width: 100%;
  text-align: center;
}

.center_bar_label{
  text-align: left;
}

.warning{
  font-size: 0.85em;
  color: red;
}

/* the link to forget password */
#forget_pwd {
  font-family: "Poppins-Redular", sans-serif;
  font-size: 1em;
  margin-right: 2em;
  color: #898A8F;
  font-weight: 900;
}

@media screen and (max-width: 992px){

  .container{
    width: 24.375em;
    height: 55em;
  }
   
  .desktop_only{
    display: none;
  }

  /* The purple background button*/
  .purple_button {
    height: 2em;
    width: 21em;
    border-radius: 25px;
    border-style: none;
    background: #5A7BEF;
    color: white;
    font-size: 16px;
    font-weight: 400;
    margin-bottom: 1em;
  }

  /* The submit button position */
  #input_submit {
    margin-top: 20px;
  }

  p {
    margin: 0;
  }

  .website_header {
    height: 28em;
    padding-top: 0px;
    margin-top: 0px;
    border-top: 0px;
    background-image: url(../assets/phone_background.png);
    background-repeat: no-repeat;
    background-size: cover;
    border-radius: 0 0 2em 2em;
  }

  .website_title {
    font-size: 20px;
    font-weight: 600;
    height: 60px;
    color: #ffffff;
    font-family: "Poppins-SemiBold", sans-serif;
    padding: 0px;
    margin: 0px;
    border: 0px;
    position: relative;
    top: 25px;
    text-align: center;
  }

  /* website content */
  .content_container {
    margin-left: 0px;
    margin-top: 30px;
  }

  .open_button {
    font-size: 2em;
    color: #FFFFFF;
    background-color: rgba(0, 0, 0, 0);
    padding: 0px;
    border: none;
    position: absolute;
    top: 2em;
    left: 1em;
    overflow-y: hidden;
  }

  #login_website_title{
    font-family: "Poppins", sans-serif;
    font-size: 3em;
    font-weight: 900;
    top: 6em;
  }

  .center_bar2 {
    justify-content: center;
    align-content: center;
  }


  .center_bar_title2{
    font-size: 1.2em;
    margin-top: 0.5em;
    margin-left: 2em;
    font-weight: 600;
    color: #3F4079;
    font-family: "Poppins-Bold", sans-serif;
  }

  .input_area2 {
    border-radius: 2em;
    margin-bottom: 1.1em;
    margin-top: 0em;
    margin-left: 0;
    height: 2em;
    width: 15em;
    border: none;
    background-color: #FFFFFF;
    box-shadow: 2px 2px 4px rgb(179 176 176);
    font-size: 1.3em;
    padding-left: 2em;
  }
}


@media screen and (min-width: 992px) {
  .phone_only {
    display: none;
  }


  .container {
    width: 120em;
    height: 80em;
    display: flex;
    margin: 0 auto;
    position: relative;
    /* keep main center_bar  at center */
    justify-content: center;
    align-items: center;
    background-color: rgba(110, 120, 247, 0.7);
    background-image: url(../assets/background.png);
    background-repeat: no-repeat;
    background-size: cover;
  }



  /* The purple background button*/
  .purple_button {
    height: 2em;
    width: 22em;
    border-radius: 2em;
    border-style: none;
    background: #5A7BEF;
    margin-bottom: 1em;
    color: white;
    font-size: 1.25em;
    font-weight: 900;
  }

  /* login page */
  h3 {
    font-size: 40px;
    color: #6E78F7;
    margin-left: 140px;
    margin-bottom: -5px;
    font-family: "Poppins-Bold", sans-serif;
    font-weight: 900;
  }

  h4 {
    font-size: 25px;
    color: #6E78F7;
    font-family: "Poppins-Regular", sans-serif;
    margin-left: 250px;
    margin-top: 0px;
    margin-bottom: 70px;
    font-weight: 900;
  }

  .center_bar2 {
    height: 762px;
    width: 560px;
    background-color: rgba(255, 255, 255, 0.8);
    position: absolute;
    border-radius: 20px;
    margin: auto;
  }

  .center_bar_title2 {
    font-size: 1.5em;
    margin-left: 2em;
    margin-top: 0;
    font-weight: 600;
    color: #3F4079;
    font-family: "Poppins-Bold", sans-serif;
  }

  .input_area2 {
    border-radius: 2em;
    margin-bottom: 1em;
    margin-top: 0.2em;
    margin-left: 0;
    height: 2.5em;
    width: 22em;
    border: none;
    font-size: 1.3em;
    padding-left: 1em;
    box-shadow: 2px 2px 4px rgb(179 176 176);
  }
}


</style>