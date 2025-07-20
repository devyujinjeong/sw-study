<script setup>

import Header from "@/components/layout/Header.vue";
</script>

<template>
  <div class="container">
    <Header/>
    <!-- 이 위치에 라우터를 끼워 달라는 의미 -->
    <RouterView/>
  </div>
</template>

<style scoped>
.container {
  margin-top: 20px;
}
</style>