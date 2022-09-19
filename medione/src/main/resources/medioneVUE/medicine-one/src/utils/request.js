import axios from "axios";


const instance = axios.create({
  timeout:6000,
  headers:{
    'Content-Type' : 'application/json'
  },
  withCredentials : true,
  crossDomain: true
})




export default instance;
