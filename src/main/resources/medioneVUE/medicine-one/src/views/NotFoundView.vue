<template>
  <div class="error-container">
      <div class="error-content">
          <div class="pic-error">
              <img alt="401" class="pic-error-parent" src="../assets/Error-404.png"/>
              <img alt="401" class="pic-error-child left" src="../assets/capsules.png"/>
              <img alt="401" class="pic-error-child mid" src="../assets/pills.png"/>
              <img alt="401" class="pic-error-child right" src="../assets/capsules.png"/>
          </div>
          <div class="bullshit">
              <div class="bullshit-oops">{{ oops }}</div>
              <div class="bullshit-headline">{{ headline }}</div>
              <div class="bullshit-info">{{ info }}</div>
              <a class="bullshit-return-home" href="#/">{{ jumpTime }}s&nbsp;{{ btn }}</a>
          </div>
      </div>
  </div>
</template>

<script>
  import { defineComponent, onMounted, onBeforeUnmount, ref, reactive } from 'vue'
  import {useRouter} from 'vue-router';
  import store from '../store/index';
  export default defineComponent ({
      name: 'Page404',
      setup() {
          const router = useRouter();
          const timer = ref(0);
          const jumpTime = ref(10);
          const oops = ref('Sorry!');
          const headline = ref('Current Page Not Found...');
          const info = ref('Please check the URL, or click the button to return to the login page');
          const btn = ref('retrun to login');
          const timeChange = () => {
              let timer = null;
              timer = setInterval(() => {
                  if (jumpTime.value > 0) {
                      jumpTime.value --;
                  } else {
                    console.log("404 check authentication")
                    console.log(store.getters.isAuthenticated)
                      // router.push("/");
                      // router.push({path:'/home', query:{id:'12' }})
                      clearInterval(timer);
                  }
              }, 1000)
          };
          onMounted(() => {
              timeChange();
          });
          onBeforeUnmount(() => {
              clearInterval(timer);
          });
          return {
              jumpTime,
              oops,
              headline,
              info,
              btn,
              timer,
          }
      },
  })
</script>

<style>
  body{
      background: #f6f8f9;
  }
  .error-container {
    width: 100%;
    height: 100%;
    text-align: left;
    background-color: rgb(216,76,126);
  }

  .error-content {
    width: 100%;
    height: 100%;
  }


  @media screen and (min-width: 992px){
    .error-container .bullshit {
      position: relative;
      float: left;
      width: 20%;
      padding: 1% 40%;
      overflow: hidden;
    }
  }

  @media screen and (max-width: 992px){
    .error-container .bullshit {
        position: relative;
        float: left;
        padding: 1% 10%;
        overflow: hidden;
    }
  }


  @keyframes slideUp {
      0% {
          opacity: 0;
          transform: translateY(60px);
      }
      100% {
          opacity: 1;
          transform: translateY(0);
      }
  }
  .error-container .bullshit-oops {
      margin-bottom: 20px;
      font-size: 3em;
      font-weight: bold;
      line-height: 40px;
      color: #00d4ff;
      /* opacity: 0; */
      animation-name: slideUp;
      animation-duration: 0.5s;
      animation-fill-mode: forwards;
  }

  .error-container .bullshit-headline {
      margin-bottom: 10px;
      font-size: 24px;
      font-weight: bold;
      line-height: 24px;
      color: #fff;
      /* opacity: 0; */
      animation-name: slideUp;
      animation-duration: 0.5s;
      animation-delay: 0.1s;
      animation-fill-mode: forwards;
  }

  .error-container .bullshit-info {
      margin-top: 2em;
      margin-bottom: 2em;
      font-size: 17px;
      line-height: 21px;
      /* color: #41b584; */
      /* opacity: 0; */
      color: #fff;
      animation-name: slideUp;
      animation-duration: 0.5s;
      animation-delay: 0.2s;
      animation-fill-mode: forwards;
  }

  .error-container .bullshit-return-home {
      display: block;
      margin-top: 4em;
      float: left;
      width: 130px;
      height: 36px;
      font-size: 14px;
      line-height: 36px;
      color: #fff;
      text-align: center;
      cursor: pointer;
      background: #409EFF;
      border-radius: 100px;
      /* opacity: 0; */
      animation-name: slideUp;
      animation-duration: 0.5s;
      animation-delay: 0.3s;
      animation-fill-mode: forwards;
      text-decoration: none;
  }
  .error-content .pic-error {
    text-align: center;
  }
  .error-content .pic-error-parent {
    display: inline;
    margin-top: 3em;
    /* overflow: hidden; */
    width: 100%;
  }
  .error-content .pic-error-child {
      position: absolute;
  }
  .error-content .pic-error-child.left {
      top: 40px;
      left: 150px;
      width: 80px;
      opacity: 0;
      animation-name: cloudLeft;
      animation-duration: 2s;
      animation-timing-function: linear;
      animation-delay: 1s;
      animation-fill-mode: forwards;
  }
  @keyframes cloudLeft {
      0% {
          top: 17px;
          left: 220px;
          opacity: 0;
      }
      20% {
          top: 33px;
          left: 188px;
          opacity: 1;
      }
      80% {
          top: 81px;
          left: 92px;
          opacity: 1;
      }
      100% {
          top: 97px;
          left: 60px;
          opacity: 0;
      }
  }
  .error-content .pic-error .mid {
      top: 0;
      left: 200px;
      width: 46px;
      opacity: 0;
      animation-name: cloudMid;
      animation-duration: 2s;
      animation-timing-function: linear;
      animation-delay: 1.2s;
      animation-fill-mode: forwards;
  }
  @keyframes cloudMid {
      0% {
          top: 10px;
          left: 420px;
          opacity: 0;
      }
      20% {
          top: 40px;
          left: 360px;
          opacity: 1;
      }
      70% {
          top: 130px;
          left: 180px;
          opacity: 1;
      }
      100% {
          top: 160px;
          left: 120px;
          opacity: 0;
      }
  }
  .error-content .pic-error .right {
      top: 80px;
      left: 250px;
      width: 62px;
      opacity: 0;
      animation-name: cloudRight;
      animation-duration: 2s;
      animation-timing-function: linear;
      animation-delay: 1s;
      animation-fill-mode: forwards;
  }
  @keyframes cloudRight {
      0% {
          top: 100px;
          left: 500px;
          opacity: 0;
      }
      20% {
          top: 120px;
          left: 460px;
          opacity: 1;
      }
      80% {
          top: 180px;
          left: 340px;
          opacity: 1;
      }
      100% {
          top: 200px;
          left: 300px;
          opacity: 0;
      }
  }
</style>
