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
  emialVerify(emailAdd){
    var data = {
      'email' : emailAdd
    }
    return axios.get
  }
}
export default api
