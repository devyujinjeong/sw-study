import { createApp } from 'vue'
import App from './App.vue'
import Toast from 'vue-toastification';
import 'vue-toastification/dist/index.css';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';

createApp(App)
    .use(Toast, {
        // 글로벌 옵션 예시
        position: 'top-right',
        timeout: 3000,
    })
    .use(ElementPlus)
    .mount('#app')