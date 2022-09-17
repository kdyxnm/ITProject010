<template>
  <div class = "side_bar" id="side_bar">
    <div class = "side_bar_title">
      <button class="close_button" @click="closeBar">
        <el-icon :size=30><CloseBold /></el-icon>
      </button>

      <h2 class="side_bar_medicine_one">
        Medicine One
      </h2>

      <div class="side_bar_team_010">
          by Team 010
      </div>
    </div>
    <!--sidebar title-->

    <hr class="side_bar_line">
    <router-link to="/">      
      <div class="side_bar_item">
        <div>
          <el-icon :size=sidebarIconSize><User /></el-icon>
          <span style="margin-left: 1em">Log in</span>
        </div>
      </div>
    </router-link>
    <!-- <router-link to="/">      
      <div class="side_bar_item">
        <div>
          <el-icon :size=sidebarIconSize><User /></el-icon>
          <span style="margin-left: 1em">Log in</span>
        </div>
      </div>
    </router-link>
    <router-link to="/">      
      <div class="side_bar_item">
        <div>
          <el-icon :size=sidebarIconSize><User /></el-icon>
          <span style="margin-left: 1em">Log in</span>
        </div>
      </div>
    </router-link> -->
    <!--log in side bar link-->
    <router-link to="/about">
      <div class="side_bar_item side_bar_selected">
        <div>
          <el-icon :size=sidebarIconSize><InfoFilled /></el-icon>
          <span style="margin-left: 1em">About</span>
        </div>
      </div>
    </router-link>
    <!--About side bar link-->
  </div>
</template>

<script>
export default {
  name: 'SideBar',
  data() {
    return {
      sidebarIconSize : 30
    }
  },
  props: {
    // msg: String
  },
  methods: {
    closeBar(){
      this.$emit("close-side-bar-event");
    }
    
  },
  mounted(){
    if (window.innerWidth < 992){
      this.sidebarIconSize = 20
    }
  }

}

</script>

<style scoped src="../assets/library/css/side_bar.css"></style>
