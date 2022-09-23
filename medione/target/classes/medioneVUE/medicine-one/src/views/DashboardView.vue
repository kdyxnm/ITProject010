<template>
  <div class="common-layout" style="height:100%">
    <el-container style="height:100%">
      <el-header height="5em" v-if='isPhone'> 
        <HeadBar :header="user.userName" @open-side-bar-event="openSideBar"></HeadBar>
      </el-header>
      <el-container>

        <el-aside class="aisde">
          <SideBar 
            :displayVersion="'complex'" 
            @close-side-bar-event="closeSideBar" 
            v-show="displayFlag" 
            ref="ChildSideBar"
            :user="{username : this.user.username, nickname : this.user.nickname}"
            @switch-event="handleSwitch"
          ></SideBar>
        </el-aside>
        
        <el-main class="main" v-if="dataReady">
          <div class="content_container">

            <div class="serach_bar_container">
              <SearchBar v-if="dataReady"></SearchBar>
            </div>



            <div v-show="displayMode == 'default'" class="dynamic_content_container">
              <MedicineList :total="this.user.numMedicine" @switch-event="handleSwitch"></MedicineList>
            </div>

            <div v-if="displayMode == 'blur_search'" class="dynamic_content_container">
              <MedicineList :total="this.user.numMedicine" @switch-event="handleSwitch"></MedicineList>
            </div>

            <div v-if="displayMode == 'medi_info'" class="dynamic_content_container">
              <h1> Medicine Information {{ this.medi_info_id }}</h1>
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
import MedicineList from '../components/MedicineList.vue'

export default {
  name: 'DashboardView',
  data() {
    return {
      displayFlag : true,
      isPhone : true,
      displayMode : 'default',
      dataReady : false,
      medi_info_id : null,
      
      
      user : {
        userName : this.$route.params.username,
        nickName : '',
        userEmail : '',
        numMedicine : null,
        locations : null,
        userMatadata : null,
      }
    }
  },
  components: {
    HeadBar,
    SideBar,
    SearchBar,
    //MedicineDetail,
    MedicineList
},
  methods: {
    openSideBar(){
      this.displayFlag = true;
    },
    closeSideBar(){
      this.displayFlag = false;
    },
    handleSwitch(mode){
      console.log("switch to " + mode)
      console.log(typeof(mode) == 'number')
      if(typeof(mode) == 'number'){
        // Medicine info
        this.displayMode = 'medi_info';
        this.medi_info_id = mode;
      }
      else if (mode == 'log_off'){
        console.log("user log off");
        alert("User log off")
      }
      else {
        this.displayMode = mode;
        if(this.isPhone){
          this.closeSideBar();
        }
      }
    },
    loadUserData(data){
      this.user.nickName = data.nickname;
      console.log(this.user.nickName);
      this.user.userEmail = data.email;
      console.log(this.user.userEmail);
      this.user.locations = data.location;
      console.log(this.user.locations);
      this.user.userMatadata = data.simplemsg;
      console.log(this.user.userMatadata);
      this.user.numMedicine = data.simplemsg.length
      console.log(this.user.numMedicine);
      this.$store.commit("updateUser", data);
    }
  },
  created(){
    this.isPhone = !(window.innerWidth > 992);
    var that = this;
    if(!this.$store.getters.isAuthenticated){
      this.$router.push({path : '/'})
    }
    console.log("Load user data form backend")
    api.getUserData().then(res =>{
      console.log(res.data);
      that.loadUserData(res.data.data);
      that.dataReady = true;
    })
  },
  mounted() {
    this.display_flag = (window.innerWidth > 992);

    // processAutoCompleteData();
    

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
