<!--
  Date/Time Library: Day.js
  - Moment.js 대체 경량 라이브러리 (2kb)
  - 주요 함수
    1. dayjs(): 현재 시간 객체 생성
    2. format(formatString): 날짜/시간 형식화
    3. add(value, unit): 특정 단위만큼 더하기 (unit: 'day', 'month', 'year', 'hour', 'minute', ...)
    4. diff(dayjsObj, unit): 두 시간 차이 계산 (unit: 'day', 'hour', 'minute', ...)
    5. parse / utc(): ISO 문자열 파싱, UTC 모드 지원
-->
<script setup>
import { ref, computed } from 'vue'
import dayjs from 'dayjs'
import utc from 'dayjs/plugin/utc'
import relativeTime from 'dayjs/plugin/relativeTime'

// 플러그인 사용
dayjs.extend(utc)
dayjs.extend(relativeTime)

// 1) 현재 시간과 형식화
const now = ref(dayjs())
const formattedNow = computed(() => now.value.format('YYYY-MM-DD HH:mm:ss'))

// 2) 더하기 예제: 7일 후, 3시간 후
const plusDays = computed(() => now.value.add(7, 'day').format('YYYY-MM-DD'))
const plusHours = computed(() => now.value.add(3, 'hour').format('HH:mm'))

// 3) 차이 예제: 특정 날짜와의 차이 (일 단위)
const targetDate = ref(dayjs().add(10, 'day'))
const diffDays = computed(() => targetDate.value.diff(now.value, 'day'))

// 4) UTC 변환 예제
const utcNow = computed(() => dayjs().utc().format())

// 5) 상대 시간 예제: fromNow
const pastDate = ref(dayjs().subtract(2, 'hour'))
const fromNow = computed(() => pastDate.value.fromNow())
</script>

<template>
  <div class="card-container">
    <div class="ui-card">
      <h3>Day.js 주요 기능 예제</h3>

      <!-- 현재 시간 형식화 -->
      <div class="example-section">
        <label>현재 시간 포맷:</label>
        <p>{{ formattedNow }}</p>
      </div>

      <!-- 날짜/시간 더하기 -->
      <div class="example-section">
        <p>7일 후 날짜: {{ plusDays }}</p>
        <p>3시간 후 시각: {{ plusHours }}</p>
      </div>

      <!-- 차이 계산 -->
      <div class="example-section">
        <label>현재와 10일 후 차이 (일):</label>
        <p>{{ diffDays }}일</p>
      </div>

      <!-- UTC 모드 -->
      <div class="example-section">
        <label>UTC 현재 시각:</label>
        <p>{{ utcNow }}</p>
      </div>

      <!-- 상대 시간 표시 -->
      <div class="example-section">
        <label>2시간 전:</label>
        <p>{{ fromNow }}</p>
      </div>
    </div>
  </div>
</template>

<style scoped>
.card-container {
  display: flex;
  justify-content: center;
  margin: 20px 0;
}
.ui-card {
  width: 100%;
  max-width: 800px;
  padding: 20px;
  border: 1px solid #ebeef5;
  box-shadow: 0 2px 12px rgba(0,0,0,0.1);
  border-radius: 8px;
  background: #fff;
}
.ui-card h3 {
  margin-bottom: 16px;
  font-size: 1.25rem;
}
.example-section {
  margin-bottom: 24px;
}
.example-section label {
  font-weight: 600;
  margin-bottom: 4px;
  display: block;
}
.example-section p {
  margin: 4px 0;
}
</style>