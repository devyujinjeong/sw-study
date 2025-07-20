<script setup>

import RegisterFrom from "@/components/user/RegisterFrom.vue";
import {registerUser} from "@/api/user.js";
import {useRouter} from "vue-router";

const router = useRouter();

const handleRegister = async (formData) => {
  // 회원 가입 api 호출
  try {
    await registerUser(formData);
    await router.push(`/login`)
  } catch (e) {
    console.log('회원 가입 실패', e);
  }
}
</script>

<template>
  <div class="container">
    <h1>회원가입</h1>
    <RegisterFrom @submit="handleRegister"/>
  </div>
</template>

<style scoped>

</style>