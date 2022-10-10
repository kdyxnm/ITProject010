<template>
  <div class="my_location_container">
    <div class="location_contrainer" v-for="(loc,index) in this.locations" :key='loc'>
      <h4> Location {{ index + 1 }} : </h4>
      <div class="loc_detail"> {{ loc }}</div>
    </div>

    <div class="add_button">
      <el-icon :size=30 color="#FFF" class="plus_icon"><Plus /></el-icon>
    </div>

    <div class="confirm_button">
      Confirm Button
    </div>

  </div>
</template>

<script>
  export default {
  name: 'Mylocation',
  data() {
    return {
      locations : ['loc1', 'loc2', 'loc3', 'loc4']
    }
  },
  methods: {

  },
  created(){
    
  }
}
</script>

<style scoped>
  /* import the Poppins font family */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap');


.add_button {
  text-align: center;
}

.plus_icon {
  width: 1.4em;
  height: 1.4em;
  background-color: #6E78F7;
  border-radius: 50%;
  transition-duration: 0.5s;
  margin-top: 1em
}

.plus_icon:hover {
  background-color: #89D3F5;
  color: white;
}

.loc_detail {
  border: #b8cbdd;
  border-style: solid;
  border-width: 1px;
  border-radius: 1em;
  padding-left: 1em;
  box-shadow: 2px 2px 2px #b8cbdd;
  font-size: 1em;
}

.location_contrainer {
  border-color: #b8cbdd;
  border-radius: 1em;
  border-width: 1px;
  border-style: solid;
  margin-top: 1em;
  padding: 0 1em 1em 1em;
  box-shadow: 2px 2px 2px #b8cbdd;
}

@media screen and (max-width: 992px){


  /* The purple background button*/
  .confirm_button {
    height: 2em;
    width: 21em;
    border-radius:2em;
    border-style: none;
    background: #5A7BEF;
    color: white;
    font-size: 16px;
    font-weight: 400;
    margin-top: 3em;
    text-align: center;
    margin-top: 1.5em;
  }
}

@media screen and (min-width: 992px) {

  /* The purple background button*/
  .confirm_button {
    height: 2em;
    width: 100%;
    border-radius: 2em;
    border-style: none;
    background: #6E78F7;
    /* margin-bottom: 1em; */
    color: white;
    font-size: 1.25em;
    font-weight: 900;
    -webkit-transition-duration: 0.5s; /* Safari */
    transition-duration: 0.5s;
    text-align: center;
    margin-top: 3em;
  }

  .confirm_button:hover {
    background-color: #89D3F5;
    color: white;
  }
}

</style>
