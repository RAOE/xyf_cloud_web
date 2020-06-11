import Vue from 'vue'
import App from './app.vue'
import router from './router'
import axios from 'axios'
import qs from 'qs'

Vue.prototype.$qs = qs;
Vue.prototype.$ajax = axios;
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')