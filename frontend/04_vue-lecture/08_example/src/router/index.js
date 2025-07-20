// 모든 통로를 여기에 설정한다고 생각하면 되는건가?
import { createRouter, createWebHistory } from 'vue-router'
import {mainRoutes} from "@/features/main/router.js";
import {productRoutes} from "@/features/product/router.js";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        ...mainRoutes,
        ...productRoutes
        // 나중에 다른 기능과 관련 된 routes 들을 추가하면 된다.
    ]
})

export default router