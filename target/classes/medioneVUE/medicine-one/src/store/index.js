import api from '../api'
import { createStore } from 'vuex'

export default createStore({
  state: {
    user : {
      authenticationFlag : false,
      userName : '',
      nickName : '',
      userEmail : '',
      numMedicine : null,
      locations : null,
      userMatadata : null,
    },
    search : {
      isAccurate : null,
      result : null
    }
  },

  getters: {
    isAuthenticated(state){
      return state.user.authenticationFlag
    },
    getLocationMap(state){
      return state.user.locations
    },
    getUserData(state){
      return state.user.userMatadata
    },
    getNumMedi(state){
      return state.user.numMedicine
    },

    getAutoCompleteData(state){
      console.log("Processing auto complete data")
      var nameLocMap = []
      for (var i = 0; i < state.user.numMedicine; i++) {
        var name = state.user.userMatadata[i].brandname;
        // console.log("Medicine : " + name);
        var locationid = state.user.userMatadata[i].locationid;
        // console.log("loc id : " + locationid);
        var address = '';

        for (var j = 0; j < state.user.locations.length; j++){
          var locName = state.user.locations[j].address;
          if(locationid == state.user.locations[j].locationid){
            address = locName;
          }
        }

        // console.log('location : ' + address)


        nameLocMap.push({
            value: name,
            link: address
        });


      }
      console.log("Finish precessing data")
      console.log(nameLocMap)
      return nameLocMap
    }
  },


  mutations: {
    authenticate(state){
      console.log("Authentication flag changed")
      state.user.authenticationFlag = true
      console.log("Auth flag " + state.user.authenticationFlag)
    },

    updateUser(state, data){

      console.log("Updating user info")
      state.user.userName = data.username;
      console.log("user name : " + state.user.userName);
      state.user.nickName = data.nickname;
      console.log("nick name : " + state.user.nickName);
      state.user.userEmail = data.email;
      console.log("user email: " + state.user.userEmail);
      state.user.numMedicine = data.simplemsg.length
      console.log("num of medicine : " + state.user.numMedicine);


      console.log("Updating user data")
      state.user.locations = data.location;
      console.log("locations : " + state.user.locations);
      state.user.userMatadata = data.simplemsg;
      console.log("metadata : " + state.user.userMatadata);

    }
  },

  actions: {
    asynUpdateUser({ commit }){
      api.getUserData().then(res => {
        console.log(res.data)
        commit('updateUser'. res.data)
      })
    }
  },
  modules: {
  }
})