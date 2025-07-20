
<script setup>
import ElementPlusExample from "@/components/ui-components/ElementPlusExample.vue";
import ValidationForm from "@/components/validation/ValidationForm.vue";
import LodashExample from "@/components/core-utility/LodashExample.vue";
import DayjsExample from "@/components/date/DayjsExample.vue";
import ToastExample from "@/components/toast/ToastExample.vue";
import ChartExample from "@/components/chart/ChartExample.vue";
</script>

<template>
  <div class="page-container">
    <!-- 유틸리티 -->
    <LodashExample/>
    <!-- 날짜/시간 처리 -->
    <DayjsExample/>
    <!-- 토스트 알림 -->
    <ToastExample/>
    <!-- 차트 -->
    <ChartExample/>
    <!-- UI 컴포넌트 -->
    <ElementPlusExample/>
    <!-- 입력 양식 유효성 검사 -->
    <ValidationForm/>
  </div>
</template>

<style scoped>
.page-container {
  width: 90%;
  max-width: 1200px;
  margin: 0 auto;
  padding: 40px 0;
  display: flex;
  flex-direction: column;
  gap: 40px;
}
</style>
