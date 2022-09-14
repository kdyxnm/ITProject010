<template>
  <div class = "website_header">
    <button @click="openNav" class="open_button">
    ☰
    </button>
    <h1 class = "website_title">
      About Medicine One
    </h1>
  </div>
  <!-- top bar -->
</template>

<script>
export default {
  name: 'HeadBar',
  data() {
    return {
    }
  },
  methods: {
    openNav() {
      this.$emit("open-side-bar-event")
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  * {
    font-family: "Poppins", sans-serif;
  }
  
  a {
    text-decoration: none;
  }
  
  
  
  .continer {
    padding-top: 0px;
    margin-top: 0px;
    border-top: 0px;
    display: flex;
  }
  
  /* phone style */
  @media screen and (max-width: 992px) {
    body{
    height: 100%;
    padding: 0px;
    margin: 0px;
    border: 0px;
    background-color: #F5F5F5;
    }
    
    /* top bar */
    header {
      display: flex;
      justify-content: center;
    }
  
    .website_header {
      height: 5em;
      width: 100%;
      padding: 0px;
      margin: 0px;
      border: 0px;
      background-color: #6E78F7;
      border-radius: 0 0 27px 27px;
    }
  
    .website_title {
      font-size: 1.6em;
      font-weight: 600;
      height: 60px;
      color: #ffffff;
      font-family: "Poppins-SemiBold", sans-serif;
      margin-top: -1em;
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
      background-color: #6E78F7;
      margin-left: 0.3em;
      border: none;
      margin-top: 0.3em;
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
  }
</style>