import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import {api} from './request/api' 


Vue.config.productionTip = false
Vue.use(mavonEditor)
Vue.prototype.$api = api

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
