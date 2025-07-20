<!--
  Notification Library: vue-toastification
  - Vue 전용 토스트 알림 라이브러리
  - 주요 기능
    • toast.success(message)
    • toast.info(message)
    • toast.warning(message)
    • toast.error(message)
    • toast.clear()
  - 설치: npm install vue-toastification@next
  - 설정: main.js 에서
      import Toast from 'vue-toastification';
      import 'vue-toastification/dist/index.css';
      app.use(Toast);
-->
<script setup>
import { useToast } from 'vue-toastification'

// 토스트 인스턴스 생성
const toast = useToast()

// 알림 타입별 함수
function showSuccess() { toast.success('성공 알림입니다!') }
function showInfo()    { toast.info('정보 알림입니다.') }
function showWarning() { toast.warning('경고 알림입니다!') }
function showError()   { toast.error('에러 알림입니다!') }
</script>

<template>
  <div class="card-container">
    <div class="ui-card">
      <h3>Vue-Toastification 알림 예제</h3>
      <div class="example-section">
        <button @click="showSuccess">Success</button>
        <button @click="showInfo">Info</button>
        <button @click="showWarning">Warning</button>
        <button @click="showError">Error</button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.card-container { display: flex; justify-content: center; margin: 20px 0; }
.ui-card { width: 100%; max-width: 800px; padding: 20px; border: 1px solid #ebeef5; box-shadow: 0 2px 12px rgba(0,0,0,0.1); border-radius: 8px; background: #fff; }
.ui-card h3 { margin-bottom: 16px; font-size: 1.25rem; }
.example-section { display: flex; gap: 8px; flex-wrap: wrap; }
.example-section button { padding: 8px 12px; border: none; border-radius: 4px; cursor: pointer; background: #409eff; color: #fff; }
</style>
