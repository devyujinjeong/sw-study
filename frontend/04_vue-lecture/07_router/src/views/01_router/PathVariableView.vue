<script setup>

import {useRoute} from "vue-router";

// 현재 라우터의 정보를 가져온다.
// 이걸 가져와서 값을 확인해보면 내가 보낸 링크에 들어있는 값이 넘어오는 것을 확인할 수 있다.
const currentRoute = useRoute()
</script>

<template>
  <div>
    <h1>PathVariable</h1>
    <!-- 01_router.js 쪽에서 가져옴 -->
    <h2>넘어온 id 값 : {{ currentRoute.params.id }}</h2>
  </div>
</template>

<style scoped>

</style>