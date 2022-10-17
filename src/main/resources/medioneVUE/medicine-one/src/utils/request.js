import axios from "axios";


const instance = axios.create({
  timeout:10000,
  headers:{
    'Content-Type' : 'application/json',
  },
  withCredentials : true,
  crossDomain: true
})


// axios.interceptors.response.use(
//   response => {
//     console.log('res------------获取的数据包括header在内')
//     console.log(response)
//     return Promise.resolve(response)
//   }, 
  
//   error => {
//     return Promise.reject(error)
//   }
// )




export default instance;
