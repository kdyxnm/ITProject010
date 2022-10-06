<template>
  <div class="common-layout" style="height:100%">
    <el-container style="height:100%">
      <el-header height="5em" v-if='isPhone'> 
        <HeadBar :header="user.nickName" @open-side-bar-event="openSideBar"></HeadBar>
      </el-header>
      <el-container>

        <el-aside class="aisde">
          <SideBar 
            :displayVersion="'complex'" 
            @close-side-bar-event="closeSideBar" 
            v-show="displayFlag" 
            ref="ChildSideBar"
            :user="{userName : this.user.userName, nickName : this.user.nickName}"
            @switch-event="handleSwitch"
          ></SideBar>
        </el-aside>
        
        <el-main class="main" v-if="dataReady">
          <div class="content_container">

            <div class="serach_bar_container">
              <SearchBar v-if="dataReady" @switch-event="handleSwitch"></SearchBar>
            </div>

            <!-- <div v-show="displayMode == 'loading'" class="dynamic_content_container">
              <h1>Loading ......</h1>
            </div> -->

            <div v-show="displayMode == 'default'" class="dynamic_content_container">
              <MedicineList :total="this.user.numMedicine" @switch-event="handleSwitch"></MedicineList>
            </div>

            <div v-if="displayMode == 'search_result'" class="dynamic_content_container">
              <MedicineList 
                :total="this.blurResult.length" 
                :isSearchResult="true" 
                :searchResult="this.blurResult"
                :key="this.blurResult"
                @switch-event="handleSwitch">
              </MedicineList>
            </div>

            <div v-if="displayMode == 'medi_info'" class="dynamic_content_container">
              <MedicineDetail :mediId="this.mediInfoId" :key="this.mediInfoId"></MedicineDetail>
              <!-- <h1> Medicine Information {{ this.mediInfoId }}</h1> -->
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
import MedicineDetail from '../components/MedicineDetail.vue'

export default {
  name: 'DashboardView',
  data() {
    return {
      displayFlag : false,
      isPhone : true,
      displayMode : 'default',
      dataReady : false,
      mediInfoId : null,
      blurResult : null,
      
      
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
    MedicineDetail,
    MedicineList,
    MedicineDetail
},
  methods: {


    openSideBar(){
      this.displayFlag = true;
    },


    closeSideBar(){
      this.displayFlag = false;
    },
    // handleRefresh(){
    //   console.log("Refresh Component")
    //   this.displayMode = 'refresh'
    // },

    handleSwitch(mode){

      console.log("switch to " + mode.view)
      if (mode.view == 'log_off'){
        console.log("user log off");
        alert("User log off")
      }
      else {
        if(mode.view == 'medi_info'){
          console.log("Medicine info of : " + this.mediInfoId)
          this.mediInfoId = mode.mediId
          console.log("Medicine info of : " + mode.mediId)
          console.log("Medicine info of : " + this.mediInfoId)
        }
        if(mode.view == 'search_result'){
          this.blurResult = mode.results
        }
        this.displayMode = mode.view;
        console.log("switch to " + this.displayMode)
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
    this.displayFlag = (window.innerWidth > 992);
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
    // this.display_flag = (window.innerWidth > 992);
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
