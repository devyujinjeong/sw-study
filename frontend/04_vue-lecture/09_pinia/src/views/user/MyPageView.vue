<script setup>

import {onMounted, ref} from "vue";
import {useAuthStore} from "@/stores/auth.js";
import {storeToRefs} from "pinia";
import UserProfileList from "@/components/user/UserProfileList.vue";
import UserProfileItem from "@/components/user/UserProfileItem.vue";
import {getUserDetail, getUsers} from "@/api/user.js";

const authStore = useAuthStore();
const { userRole } = storeToRefs(authStore);  // 스토어의 state를 반응성 변수화

const isLoading = ref(true);
const userDetail = ref(null);   // 유저 한명의 정보
const userList = ref([]);       // 유저 여러명의 정보

// 관리자용 전체 회원 목록 조회
const fetchUsers = async () => {
  try {
    const resp = await getUsers();
    userList.value = resp.data.data.users;
    isLoading.value = false;
  } catch (e) {
    console.log('전체 회원 목록 조회 실패', e);
  }
}

// 내 정보 조회
const fetchDetail = async () => {
  try {
    const resp = await getUserDetail();
    userDetail.value = resp.data.data.user;
    isLoading.value = false;
  } catch (e) {
    console.log('내 정보 조회 실패', e);
  }
}

onMounted(async () => {
  if(userRole.value === 'ADMIN')
    await fetchUsers()
  else
    await fetchDetail()
})

</script>

<template>
  <div class="my-page">
    <h1>마이페이지</h1>
    <div v-if="isLoading">Loading...</div>
    <div v-else>
      <!-- 관리자 전용 : 전체 회원 목록 -->
      <section v-if="userRole === 'ADMIN'" class="section">
        <h2>전체 회원 목록</h2>
        <UserProfileList :users="userList"/>
      </section>
      <!-- 일반 유저 : 본인 정보 -->
      <section v-else class="section">
        <h2>내 정보</h2>
        <UserProfileItem :user="userDetail"/>
      </section>
    </div>
  </div>

</template>

<style scoped>
.my-page {
  max-width: 800px;
  margin: 2rem auto;
  padding: 1rem;
  background: #f7f7f7;
  border-radius: 6px;
}
.section {
  margin-bottom: 2rem;
}
</style>