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

<style scoped>
/* import the Poppins font family */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap');

* {
  font-family: "Poppins", sans-serif;
}

@media screen and (max-width: 992px) {

  .side_bar{
    height: 100%;
    width: 12em;
    top: 0;
    left: 0;
    margin-top: 0;
    margin-left: 0;
    /*Stays in place */
    background-color: #5c66ee;
    border-radius: 0 20px 20px 0;
    position: absolute;
    /*green*/
    overflow-x: hidden;
    /*for Disabling horizontal scroll */
  }

  .side_bar_title {
    display: block;
    color: #FFFFFF;
    margin-left: 1em;

  }

  .close_button {
    margin-left: 10px;
    background-color: rgba(0, 0, 0, 0);
    position: relative;
    border: none;
    top: 5em;
  }
  
  .close_button_icon{
    height: 18px;
    width: 18px;
  }

  .side_bar_medicine_one{
    display: block;
    font-size: 1.3em;
    margin-block-start: 0.83em;
    margin-block-end: 0.83em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-top: 1em;
    font-weight: bold;
    position: relative;
    top: 70px;
    
  }

  .side_bar_team_010 {
    font-size: 12px;
    margin-top: -20px;
    margin-bottom: 10px;
    position: relative;
    top: 70px;
  }

  .side_bar_item {
    margin-top: 3em;
    padding-left: 1em;
    color: #FFFFFF;
    font-size: 15px;
    padding-top: 10px;
    padding-bottom: 10px;
    position: relative;
    top: 70px;
  }

  .side_bar_icon {
    width: 18px;
    height: 20px;
    display: none;
  }

  .side_bar_selected {
    background-color: #505bf5;
  }

  .el-icon svg {
    color : #FFFFFF;
    padding-top : 0.3em;
  }

}






@media screen and (min-width: 992px) {
  .side_bar {
    height: 90%;
    width: 90%;
    margin-left: 1em;
    background-color: #F5F5F5;
    border-radius: 1em;
    /* position: relative; */

  }
  
  .side_bar_title {
    display: block;
    color: #6E78F7;
    margin-left: 1.2em;
  }
  
  .side_bar_medicine_one{
    display: block;
    font-size: 1.7em;
    margin-block-start: 0.83em;
    margin-block-end: 0.83em;
    margin-inline-start: 0;
    margin-inline-end: 0;
    padding-top: 1em;
    font-weight: bold;
  }

  
  .side_bar_item {
    font-size: 1.2em;
    margin-bottom: 2em;
    padding-left: 1em;
  }
  
  .side_bar_icon {
    width: 18px;
    height: 20px;
  }
  
  .side_bar_selected {
    background-color: #DFE0E2;
  }
  
  .side_bar_line {
    border: 1px solid #D3D3D3;
    margin-top: 30px;
    margin-bottom: 30px;
  }

  .close_button {
    display: none;
  }

  .el-icon svg {
    color : #6E78F7;
    padding-top : 0.3em;
  }

}

</style>