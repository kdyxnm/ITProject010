<template>
  <div class="common-layout">
    <el-container>
      <el-header height="8em"> <HeadBar @open-side-bar-event="openSideBar"></HeadBar></el-header>
      <el-container>
        <el-aside class="aisde"> <SideBar @close-side-bar-event="closeSideBar" v-show="display_flag" ref="ChildSideBar"></SideBar></el-aside>
        <el-main class="main">
          <div class="about_content">
            <h2>
              What we do
            </h2>
            <p>
              bababababababababababbababab
              babababbababbabababbabababba
              babababbababbabababbabababba
              bababababababababababbababab
              babababbababbabababbabababbb
            </p>
          </div>
  
          <div class="about_content">
            <h2>
              Vision Statement
            </h2>
            <p>
                bababababababababababbababab
                babababbababbabababbabababba
                babababbababbabababbabababba
            </p>
          </div>
  
          <div class="about_content">
            <h3>
              Contact Us
            </h3>
            <p>
                bababababababababababbababab
                babababbababbabababbabababba
                babababbababbabababbabababba
            </p>
          </div></el-main>
      </el-container>
    </el-container>
  </div>


</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import HeadBar from '../components/HeadBar.vue'
import SideBar from '../components/SideBar.vue'
import SomeComponent from '../components/SomeComponent.vue'

export default {
  name: 'AboutView',
  data() {
    return {
      display_flag : true
    }
  },
  components: {
    HelloWorld,
    HeadBar,
    SideBar,
    SomeComponent
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
  },
}
</script>

<style>
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

.main {
  padding-top: 0px;
  margin-top: 0px;
  border-top: 0px;
}

/* desktop style */
@media screen and (min-width: 992px) {
  /* website content */
  .content_container {
    width: 65%;
    margin-left: 0;
    margin-top: 0;
  }

  .open_button {
    display: none;
  }

  aside.el-aside.aisde {
    width: 20em;
  }

  .main {
    height: 100%em;
  }
  .about_content{
    font-size: larger;
    margin-top: 60px;
  }
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
}

</style>
