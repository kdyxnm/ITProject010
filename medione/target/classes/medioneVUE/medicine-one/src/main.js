import { createApp } from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
import elementIcon from './plugins/icons'
import axios from 'axios'


const app = createApp(App);
// app.config.globalProperties.$axios = axios
app.use(elementIcon).use(store).use(router);
app.mount('#app')
// createApp(App).use(elementIcon).use(store).use(router).mount('#app')

axios.defaults.withCredentials = true