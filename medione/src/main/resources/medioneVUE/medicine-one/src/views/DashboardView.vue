<template>
  <div class="common-layout" style="height:100%">
    <el-container style="height:100%">
      <el-header height="8em" v-if='isPhone'> 
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
          ></SideBar>
        </el-aside>
        <el-main class="main">
          <div class="content_container">
            <SearchBar></SearchBar>


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

export default {
  name: 'DashboardView',
  data() {
    return {
      display_flag : true,
      isPhone : true,
      
      user : {
        username : 'superadmin',
        nickname : 'superbaby',
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
    }
  },
  mounted() {
    this.display_flag = (window.innerWidth > 992);
    this.isPhone = !(window.innerWidth > 992);
  },
}
</script>

<style scpoed>


</style>
