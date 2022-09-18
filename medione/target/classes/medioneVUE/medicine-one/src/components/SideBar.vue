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

    <hr class="side_bar_line" v-if="displayVersion == 'complex'"/>

    <div class="side_bar_item" v-if="displayVersion == 'complex'" @click="switchMode('default')">
      <div style="padding-right:1.2em">
        <el-icon :size=sidebarIconSize><House /></el-icon>
        <span style="margin-left: 1em"> Dashboard </span>
        <p class="user_name">{{user.username}}</p>
        <p class="user_nick_name">{{user.nickname}}</p>
      </div>
    </div>


    <hr class="side_bar_line" style="margin-top: 1em;"/>


    <router-link to="/" v-if="displayVersion == 'simple'">      
      <div class="side_bar_item">
        <div>
          <el-icon :size=sidebarIconSize><User /></el-icon>
          <span style="margin-left: 1em">Log in</span>
        </div>
      </div>
    </router-link>


    <!--log in side bar link-->
    <router-link to="/about" v-if="displayVersion == 'simple'">
      <div class="side_bar_item side_bar_selected">
        <div>
          <el-icon :size=sidebarIconSize><InfoFilled /></el-icon>
          <span style="margin-left: 1em">About</span>
        </div>
      </div>
    </router-link>
    <!--About side bar link-->



    <div class="side_bar_item" v-if="displayVersion == 'complex'" @click="switchMode('add_medi')">
      <div>
        <el-icon :size=sidebarIconSize><CirclePlus /></el-icon>
        <span style="margin-left: 1em">Add Medicine</span>
      </div>
    </div>     


    <div class="side_bar_item" v-if="displayVersion == 'complex'" @click="switchMode('my_loca')">
      <div>
        <el-icon :size=sidebarIconSize><Location /></el-icon>
        <span style="margin-left: 1em">My Location</span>
      </div>
    </div>

    
    <div class="side_bar_item" v-if="displayVersion == 'complex'" @click="switchMode('log_off')">
      <div>
        <el-icon :size=sidebarIconSize><SwitchButton /></el-icon>
        <span style="margin-left: 1em">Log off</span>
      </div>
    </div>


    <div class="side_bar_item" v-if="displayVersion == 'complex'" @click="switchMode('about')">
      <div>
        <el-icon :size=sidebarIconSize><InfoFilled /></el-icon>
        <span style="margin-left: 1em">About</span>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: 'SideBar',
  data() {
    return {
      sidebarIconSize : 30,
    }
  },
  props: {
    displayVersion : {
      type : String,
      default : "simple"
    },
    user : {
      type : Object,
      default : {
        username : "User Name",
        nickname : "User Nick Name",
      }
    }
  },
  methods: {
    closeBar(){
      this.$emit("close-side-bar-event");
    },
    switchMode(mode){
      this.$emit("switch-event", mode);
    },

    
  },
  mounted(){
    if (window.innerWidth < 992){
      this.sidebarIconSize = 20
    }
  }

}

</script>

<style scoped src="../assets/library/css/side_bar.css"></style>
