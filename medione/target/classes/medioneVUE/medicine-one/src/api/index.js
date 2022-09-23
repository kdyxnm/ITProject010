import axios from '../utils/request'
import path from './path'

const api = {
  login(username, pwd){
    var userinfo = {
      'username':username,  
      'password':pwd,
    };
    return axios.post(path.baseUrl + path.login, userinfo)
  },
  emailVerify(userName, email){
    var emailinfo = {
      'username' : userName,
      'email' : email
    }
    return axios.post(path.baseUrl + path.email, emailinfo)
  },
  register(email, code, userName, nickName, pwd){
    var registerinfo = {
      'email': email,
      'code': code,
      'username': userName,
      'nickname': nickName,
      'password': pwd,
    };
    return axios.post(path.baseUrl + path.register, registerinfo)
  },
  getUserData(){
    return axios.get(path.baseUrl + path.dashboard)
  },
  getPageData(curpage, pagesize){
    console.log(path.baseUrl + path.pagination + "/" + curpage + "/" + pagesize)
    return axios.get(path.baseUrl + path.pagination + "/" + curpage + "/" + pagesize)
  },
  accurateSearch(mediname, location){
    return axios.get(path.baseUrl + path.search + mediname + '/' + location)
  },
  blurrySearch(mediname){
    return axios.get(path.baseUrl + path.search + mediname)
  }
}
export default api
