import axios2 from "axios";


const instance2 = axios2.create({
  timeout:15000,
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




export default instance2;