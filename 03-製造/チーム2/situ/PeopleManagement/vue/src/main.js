import Vue from 'vue';
import App from './App.vue';
import router from './router';
import ElementUI from 'element-ui';
import locale from 'element-ui/lib/locale/lang/ja';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/global.css';
import request from "@/utils/request";
import axios from 'axios';

Vue.config.productionTip = false
Vue.use(ElementUI, {locale});

//var axios = require('axios')
// 全局注册
Vue.prototype.$axios = axios
Vue.prototype.request = request()

// 设置反向代理，前端请求默认发送到 http://localhost:8888/api
axios.defaults.baseURL = 'http://localhost:8090/api'



new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
