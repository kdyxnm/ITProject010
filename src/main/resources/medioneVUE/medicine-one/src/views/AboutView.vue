<template>
  <div class="common-layout" style="height:100%">
    <el-container style="height:100%">
      <el-header height="8em"> <HeadBar @open-side-bar-event="openSideBar"></HeadBar></el-header>
      <el-container>
        <el-aside class="aisde">
          <SideBar @close-side-bar-event="closeSideBar" v-show="display_flag" ref="ChildSideBar">

          </SideBar>
        </el-aside>
        <el-main class="main">
          <div class="about_content">
            <h2>
              What we do
            </h2>
            <p>
              asdlfjnalksjd asdkfnl  asdf asdf a asdf asgq sadf qwe dfsvad fsdfg wE SF
              bababababababababababbababab
              babababbababbabababbabababba
              babababbababbabababbabababba
              bababababababababababbababab
              babababbababbabababbabababbb
              bababababababababababbababab
              babababbababbabababbabababba
              babababbababbabababbabababba
              bababababababababababbababab
              babababbababbabababbabababbb
              bababababababababababbababab
              babababbababbabababbabababba
              babababbababbabababbabababba
              bababababababababababbababab
              babababbababbabababbabababbb
              bababababababababababbababab
              babababbababbabababbabababba
              babababbababbabababbabababba
              bababababababababababbababab
              babababbababbabababbabababbb
              bababababababababababbababab
              babababbababbabababbabababba
              babababbababbabababbabababba
              bababababababababababbababab
              babababbababbabababbabababbb
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
import HeadBar from '../components/HeadBar.vue'
import SideBar from '../components/SideBar.vue'

export default {
  name: 'AboutView',
  data() {
    return {
      display_flag : true
    }
  },
  components: {
    HeadBar,
    SideBar,
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

<style scpoed src="../assets/library/css/about.css"></style>
