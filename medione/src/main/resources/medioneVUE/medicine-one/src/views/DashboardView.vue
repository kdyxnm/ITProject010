<template>
  <div class="common-layout" style="height:100%">
    <el-container style="height:100%">
      <el-header height="5em" v-if='isPhone'> 
        <HeadBar :header="user.username" @open-side-bar-event="openSideBar"></HeadBar>
      </el-header>
      <el-container>

        <el-aside class="aisde">
          <SideBar 
            :displayVersion="'complex'" 
            @close-side-bar-event="closeSideBar" 
            v-show="display_flag" 
            ref="ChildSideBar"
            :user="{username : this.user.username, nickname : this.user.nickname}"
            @switch-event="handleSwitch"
          ></SideBar>
        </el-aside>
        
        <el-main class="main">
          <div class="content_container">

            <div class="serach_bar_container">
              <SearchBar></SearchBar>
            </div>



            <div v-if="displayMode == 'default'" class="dynamic_content_container">
              <h1> Medicine list component</h1>
            </div>

            <div v-if="displayMode == 'medi_info'" class="dynamic_content_container">
              <h1> Medicine Description</h1>
            </div>


            <div  v-if="displayMode == 'add_medi'" class="dynamic_content_container">
              <h1> Add medicine component</h1>
            </div>


            <div  v-if="displayMode == 'my_loca'" class="dynamic_content_container">
              <h1> Add location component</h1>
            </div>


            <div v-if="displayMode == 'about'" class="dynamic_content_container">
              <h1> About component version 2</h1>
            </div>

            


          </div></el-main>
      </el-container>
    </el-container>
  </div>


</template>

<script>
// @ is an alias to /src
import HeadBar from '../components/HeadBar.vue'
import SideBar from '../components/SideBar.vue'
import SearchBar from '../components/SearchBar.vue'
import api from '../api/index'

export default {
  name: 'DashboardView',
  data() {
    return {
      display_flag : true,
      isPhone : true,
      displayMode : 'default',
      
      user : {
        username : this.$route.params.username,
        nickname : '',
        useremial : '',
        usermatadata : {},
      }
    }
  },
  components: {
    HeadBar,
    SideBar,
    SearchBar,
  },
  methods: {
    openSideBar(){
      this.display_flag = true;
    },
    closeSideBar(){
      this.display_flag = false;
    },
    handleSwitch(mode){
      if (mode == 'log_off'){
        console.log("user log off");
        alert("User log off")
      }
      else {
        this.displayMode = mode
      }
    }
  },
  beforeMount(){
    this.isPhone = !(window.innerWidth > 992);
  },
  mounted() {
    this.display_flag = (window.innerWidth > 992);
    if(!this.$store.getters.isAuthenticated){
      this.$router.push({path : '/'})
    }
    console.log("Load user data form backend")
    api.getUserData().then(res =>{
      console.log(res.data)
    })
    

  },
}
</script>

<style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap');

  * {
    font-family: "Poppins", sans-serif;
  }
  
  a {
    text-decoration: none;
  }
  .common-layout{
    margin: 0;
    border: 0;
    padding: 0;
  }
  header.el-header {
    padding: 0;
    margin: 0;
    border: 0;
  }

  .dynamic_content_container{
    width: 100%;
    margin-top:1em
  }
  
  .main {
    padding-top: 0px;
    margin-top: 0px;
    border-top: 0px;
  }

  
  /* phone version */
  @media screen and (max-width: 992px) {
    .about_content > * {
      font-size: medium;
      margin-top: 10px;
    }
    aside.el-aside.aisde {
      width: 0;
    }

    .el-input__wrapper {
      align-items: center;
      margin-top: 1em;
      z-index: -1;
    }

    .serach_bar_container {
      width: 100%;
      height: 3em;
      margin-top: 1em;
    }

  }








  /* desktop style */
  @media screen and (min-width: 992px) {
    /* website content */
    .content_container {
      width: 100%;
      margin-left: 0;
      margin-top: 2em;
    }
  
    .open_button {
      display: none;
    }
  
    aside.el-aside.aisde {
      width: 20em;
    }
  
    .main {
      height: 100%;
    }
    .about_content{
      font-size: larger;
      margin-top: 60px;
    }




    .serach_bar_container {
      width: 100%;
      height: 4em;
      margin-top: 2em;
    }
  }

</style>
