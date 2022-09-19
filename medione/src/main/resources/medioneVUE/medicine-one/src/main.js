import { createApp } from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
import elementIcon from './plugins/icons'

const app = createApp(App);
// app.config.globalProperties.$axios = axios
app.use(elementIcon).use(store).use(router);
app.mount('#app')
// createApp(App).use(elementIcon).use(store).use(router).mount('#app')
