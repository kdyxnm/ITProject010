<template>
  <div class = "website_header">
    <button v-if="btnStyle == sidebar" @click="openNav" class="open_button">
      <el-icon><Expand /></el-icon>
    </button>
    <button v-if="btnStyle == returnbtn" @click="backToPrev" class="open_button">
      <el-icon><Back /></el-icon>
    </button>

    <h1 class = "website_title">
      {{ header }}
    </h1>
  </div>
  <!-- top bar -->
</template>

<script>
export default {
  name: 'HeadBar',
  props : {
    header : {
      type : String,
      default : "About"
    },
    btnStyle : {
      type : String,
      default : "SideBar"
    }
  },
  data() {
    return {
      sidebar : "SideBar",
      returnbtn : "Return"
    }
  },
  methods: {
    openNav() {
      this.$emit("open-side-bar-event")
    },
    backToPrev(){
      this.$router.back(-1)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  * {
    font-family: "Poppins", sans-serif;
  }
  
  /* phone style */
  @media screen and (max-width: 992px) {
  
    .website_header {
      height: 5em;
      width: 100%;
      padding: 0px;
      margin: 0px;
      border: 0px;
      background-color: #6E78F7;
      border-radius: 0 0 27px 27px;
      display: flex;
    }
  
    .website_title {
      font-size: 1.6em;
      font-weight: 600;
      width: 100%;
      color: #ffffff;
      font-family: "Poppins-SemiBold", sans-serif;
      margin: 0;
      text-align: center;
      padding-top: 1em;
      position: relative;
      right: 1em;
    }
  
    .open_button {
      font-size: 2em;
      color: #FFFFFF;
      background-color: rgba(0,0,0,0);
      margin-left: 0.3em;
      border: none;
      margin-top: 0.3em;
    }

    .return_button {
      height: 3%;
      width: 3%;
      background-image: url(../assets/white_left_arrow.png);
      background-size: contain;
      position: fixed;
      top: 30px;
      left: 30px;
      display: none;
    }
  }

  @media screen and (min-width: 992px) {
    /* top bar */
    .website_header {
      height: 100%;
      padding-top: 0px;
      margin-top: 0px;
      border-top: 0px;
      background-color: #6E78F7;
      border-radius: 0 0 60px 60px;
    }
    
    .website_title {
      font-size: 60px;
      font-weight: 600;
      color: #ffffff;
      font-family: "Poppins-SemiBold", sans-serif;
      padding-top: 0.3em;
      margin-top: 0;
      text-align: center;
    }

    .open_button {
      display: none;
    }
  }
</style>
