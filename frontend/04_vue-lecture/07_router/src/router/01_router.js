import {createRouter, createWebHistory} from "vue-router";
import HomeView from "@/views/01_router/HomeView.vue";
import PathVariableView from "@/views/01_router/PathVariableView.vue";
import QueryStringView from "@/views/01_router/QueryStringView.vue";

// router 객체를 생성하는 메소드
const router = createRouter({
    // url 관리 방식을 선택하는 것으로 밑에 설정은 #이 없이 url이 설정된다.
    history: createWebHistory(),
    /* 밑에 나오는 요청이 들어오는 경우 이렇게 할거예요! 라는 것*/
    routes : [
        {
            path : '/',
            name : 'home',
            component : HomeView
        },
        {
            /* PathVariable 방식으로 라우팅 할 경우 해당 값을 처리한 변수명을 작성한다. */
            path : '/pathvariable/:id',
            name : 'path-variable',
            component : PathVariableView
        },
        {
            path : '/querystring',
            name : 'query-string',
            component : QueryStringView
        }
    ]
});

/* export 해줘야 가져다 쓸 수 있음 */
export default router;