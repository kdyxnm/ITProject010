import api from '../api'
import { createStore } from 'vuex'

export default createStore({
  state: {
    user : {
      name : null,
      nickname : null,
      authenticationFlag : false,
      userData : {
        locationMap : null,
        medicineMap : null
      }
    },
    sessionID : null,
  },

  getters: {
    isAuthenticated(state){
      return state.user.authenticationFlag
    },
    getLocationMap(state){
      return state.user.userData.locationMap
    },
    getLocationName(state, id){
      for(i=0; i < state.user.userData.locationMap.length; i++){
        if (state.user.userData.locationMap[i].id == id){
          return state.user.userData.locationMap[i].address
        }
        return "INVALID_ID"
      }
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
      console.log("username : " + data.data.username)
      console.log("nickname : " + data.data.username)
      state.user.name = data.data.username
      state.user.nickname = data.data.username



      console.log("Updating user data")
      console.log("User location" + data.data.locationMap)
      state.user.userData.locationMap = data.data.locationMap;
      console.log("User Data" + data.data.data)
      state.user.userData.locationMap = data.data.data;
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
