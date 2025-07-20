<script setup>
import { defineEmits } from 'vue';

/* 부모로부터 물려 받은 toggle이라는 이름의 이벤트를 호출 할 수 있는 반환 값을 받는다.
* 배열에 이벤트 이름을 작성한다. */
const emit = defineEmits(['toggle']);
</script>

<template>
  <!-- 부모 컴포넌트에서 받은 toggle 이벤트 호출
  여기에서 버튼을 클릭해주면 부모쪽에 있는 다크 모드가 실행되는 것이다. -->

  <button @click="emit('toggle')">다크 모드 토글 버튼</button>
</template>

<style scoped>

</style>