<script setup>
import { ref } from 'vue';
// 배열 형태로 ref 속성의 값을 가지고 있음
const users = ref([
  { id: 1, name: '유관순', age: 25 },
  { id: 2, name: '홍길동', age: 30 },
  { id: 3, name: '선덕여왕', age: 35}
]);
</script>

<template>
  <ul>
    <li v-for="user in users" :key="user.id">
      <!--
        user 데이터를 slot으로 바인딩 (v-bind:user)
        user라는 이름의 슬롯 프로퍼티를 부모에게 공개한다.
      -->

      <!--
        부모에게 여기를 사용할 수 있게 제공해주는 것 뿐만 아니라,
        user 데이터까지 제공해서 부모가 user 데이터를 쓸 수 있게 허용
      -->
      <slot :user="user">
        <!-- 부모가 아무 값도 주지 않았을 경우의 기본 콘텐츠를 정의한다. -->
        {{ user.name }} ({{ user.age }})
      </slot>
    </li>
  </ul>
</template>

<style scoped>

</style>