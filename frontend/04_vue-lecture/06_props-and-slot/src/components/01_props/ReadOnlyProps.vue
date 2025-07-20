<script setup>
const props = defineProps({
  readValue : String
})
</script>

<template>
  <h1> {{ props.readValue }}</h1>
 <!-- 이 부분을 변경하면 어떻게 될까?
 여기에서 값을 변경하면 우선 값이 바뀌지 않고, console창에서 에러 메세지가 뜬다.-->
  자식의 readValue : <input type="text" v-model="props.readValue">
</template>

<style scoped>

</style>