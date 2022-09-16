import axios from "axios";
import querystring from 'querystring';

const instance = axios.create({
  timeout:6000

})

instance.request.use()


export default instance;
