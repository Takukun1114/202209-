import Vue from 'vue';
import App from './App.vue';
import router from './router';
import ElementUI from 'element-ui';
import locale from 'element-ui/lib/locale/lang/ja';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/global.css';
import axios from 'axios';
import 'default-passive-events';

Vue.config.productionTip = false
Vue.use(ElementUI, {locale});

// 全局注册
// グローバル登録
//var axios = require('axios')
Vue.prototype.$axios = axios

// 设置反向代理，前端请求默认发送到 http://localhost:8888/api
// リバース プロキシを設定します。フロントエンド リクエストはデフォルトで http://localhost:8888/api に送信されます
axios.defaults.baseURL = 'http://localhost:8090/'

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
