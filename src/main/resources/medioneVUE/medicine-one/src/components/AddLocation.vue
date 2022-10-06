<template>
  <div>
    <button @click="sendToFather">CLICK FOR TESTING</button>
  </div>
</template>

<script>
  export default {
  name: 'SomeCmponent',
  data() {
    return {
    }
  },
  methods: {
    sendToFather() {
      alert("click in child")
      this.$emit("open-side-bar-event", true)
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

a {
  text-decoration: none;
}

.container {
  padding-top: 0;
  margin-top: 0;
  border-top: 0;
  background-color: #F5F5F5;
}

.center_bar_content{
  width: 100%;
  text-align: center;
}

.center_bar_label{
  text-align: left;
}

.warning{
  font-size: 0.85em;
  color: red;
}

/* the link to forget password */
#forget_pwd {
  font-family: "Poppins-Redular", sans-serif;
  font-size: 1em;
  margin-right: 2em;
  color: #898A8F;
  font-weight: 900;
}

@media screen and (max-width: 992px){

  .container{
    width: 100%;
    height: 100%;
  }
   
  .desktop_only{
    display: none;
  }

  /* The purple background button*/
  .purple_button {
    height: 2em;
    width: 21em;
    border-radius:2em;
    border-style: none;
    background: #5A7BEF;
    color: white;
    font-size: 16px;
    font-weight: 400;
    margin-bottom: 1em;
  }


  p {
    margin: 0;
  }

  .website_header {
    height: 54%;
    padding-top: 0;
    margin-top: 0;
    border-top: 0;
    background-image: url(../assets/phone_background.png);
    background-repeat: no-repeat;
    background-size: cover;
    border-radius: 0 0 2em 2em;
  }

  .website_title {
    font-size: 3em;
    font-weight: 900;
    color: #ffffff;
    padding: 0;
    margin: 0;
    text-align: center;
    position: relative;
    top: 6em;
  }

  /* website content */
  .content_container {
    margin-left: 0px;
    margin-top: 30px;
  }

  .open_button {
    font-size: 2em;
    color: #FFFFFF;
    background-color: rgba(0, 0, 0, 0);
    padding: 0px;
    border: none;
    position: absolute;
    top: 2em;
    left: 1em;
    overflow-y: hidden;
  }


  .center_bar {
    justify-content: center;
    align-content: center;
  }


  .center_bar_title{
    font-size: 1.2em;
    margin-top: 0.5em;
    margin-left: 2em;
    font-weight: 600;
    color: #3F4079;
    font-family: "Poppins-Bold", sans-serif;
  }

  .input_area {
    border-radius: 2em;
    margin-bottom: 1.1em;
    margin-top: 0em;
    margin-left: 0;
    height: 2em;
    width: 15em;
    border: none;
    background-color: #FFFFFF;
    box-shadow: 2px 2px 4px rgb(179 176 176);
    font-size: 1.3em;
    padding-left: 2em;
  }
}

@media screen and (min-width: 992px) {
  .phone_only {
    display: none;
  }


  .container {
    height: 100%;
    width: 100%;
    display: flex;
    margin: 0 auto;
    position: relative;
    /* keep main center_bar  at center */
    justify-content: center;
    align-items: center;
    background-color: rgba(110, 120, 247, 0.7);
    background-image: url(../assets/background.png);
    background-repeat: no-repeat;
    background-size: cover;
  }



  /* The purple background button*/
  .purple_button {
    height: 2em;
    width: 22em;
    border-radius: 2em;
    border-style: none;
    background: #5A7BEF;
    margin-bottom: 1em;
    color: white;
    font-size: 1.25em;
    font-weight: 900;
  }

  /* login page */
  h3 {
    font-size: 40px;
    color: #6E78F7;
    margin-left: 140px;
    margin-bottom: -5px;
    font-family: "Poppins-Bold", sans-serif;
    font-weight: 900;
  }

  h4 {
    font-size: 25px;
    color: #6E78F7;
    font-family: "Poppins-Regular", sans-serif;
    margin-left: 250px;
    margin-top: 0px;
    margin-bottom: 70px;
    font-weight: 900;
  }

  .center_bar {
    background-color: rgba(255, 255, 255, 0.8);
    position: absolute;
    border-radius: 20px;
    margin: auto;
    padding-top: 1.5em;
    padding: 1em;
  }

  .center_bar_title {
    font-size: 1.5em;
    margin-left: 2em;
    margin-top: 0;
    font-weight: 600;
    color: #3F4079;
    font-family: "Poppins-Bold", sans-serif;
  }

  .input_area {
    border-radius: 2em;
    margin-bottom: 1em;
    margin-top: 0.2em;
    margin-left: 0;
    height: 2.5em;
    width: 22em;
    border: none;
    font-size: 1.3em;
    padding-left: 1em;
    box-shadow: 2px 2px 4px rgb(179 176 176);
  }
}

</style>
