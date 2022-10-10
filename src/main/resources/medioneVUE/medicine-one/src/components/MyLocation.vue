<template>
  <div class="my_location_container">
    <div class="location_contrainer" v-for="(loc,index) in this.locations" :key='loc'>
      <h4> Location {{ index + 1 }} : <el-icon class="close_icon" :size="20" @click="deleteLoc(index)"><CloseBold /></el-icon></h4>
      
      <div class="loc_detail"> {{ loc.address }}</div>
    </div>

    <div class="add_button" v-show="this.locations.length < 5">
      <el-icon :size=30 color="#FFF" class="plus_icon" @click="addNewLoc()"><Plus /></el-icon>
    </div>

    <div v-show="this.isAdding" class="add_loc_bar">
      <div>
        <input type="text" class="input_bar" v-model="this.newLocstring">
      </div>
       <div class="confirm_button" @click="confirmAdd()">
        Confirm Button
      </div>
      <div class="confirm_button" @click="clsoeNewLocBar()">
        Cancle
      </div>   
    </div>


  </div>
</template>

<script>
  import store from '../store/index'
  import api from '../api/index'

  export default {
  name: 'Mylocation',
  data() {
    return {
      isAdding : false,
      locations : [],
      newLocstring : '',
    }
  },
  methods: {

    addNewLoc(){
      console.log("adding new locations")
      if(this.locations.length < 5){
        this.isAdding = true
      }
      else {
        ElMessage.error('At most 5 locations')
      }
    },

    confirmAdd(){
      console.log('new location is ' + this.newLocstring)
      var emial = store.getters.getEmail
      var locInfo = {
        "locationid" : -1,
        "email" : emial,
        "address" : this.newLocstring
      }
      var that = this
      api.addLocation(locInfo).then(res => {
        console.log(res.data)
        // that.locations.push(locInfo)
        that.clsoeNewLocBar()
        // that.newLocstring = ''
      })
      // this.clsoeNewLocBar()
      // this.locations.push(locInfo)
      // this.newLocstring = ''
    },

    clsoeNewLocBar(){
      console.log("close new loc bar")
      this.isAdding = false
    },

    deleteLoc(index){
      console.log("Delete location " + this.locations[index].address)
      var locInfo = this.locations[index]
      var that = this
      // api.deleteLocation(locInfo).then(res => {
      //   console.log(res.data)
      //   that.locations.splice(index, 1)
      // })
      this.locations.splice(index, 1)
    },

    
    


  },
  created(){
    this.locations = store.getters.getLocations
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
  transition: 0.3s
}

.location_contrainer:hover{
  box-shadow: 10px 10px 10px #8294a3;
}

.add_loc_bar {
  border-width: 1px;
  border-style: solid;
  border-color: #b8cbdd;
  border-radius: 1em;
  padding: 0 1em 1em 1em;
  box-shadow: 3px 3px 3px #b8cbdd;
  margin-top: 1em;

}

@media screen and (max-width: 992px){


  /* The purple background button*/
  .confirm_button {
    height: 2em;
    /* width: 21em; */
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

  .close_icon{
    position: relative;
    left: 10em;
    color: #FFF;
    background-color: #6E78F7;
    border-radius: 1em;
  }

  .input_bar {
    width: 90%;
    font-size: 1.5em;
    margin-top: 1em;
    border-radius: 1em;
    padding: 0 5%;
    border-width: 0;
    box-shadow: 2px 2px 2px #b8cbdd;
  }

  h4 {
    margin-bottom: 0.6em;
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

  .close_icon{
    position: relative;
    left: 55em;
    color: #FFF;
    background-color: #6E78F7;
    border-radius: 1em;
  }
}

</style>
