<!--
  Utility Library: Lodash-es
  - JavaScript 유틸리티 라이브러리 Lodash의 ES 모듈 버전
  - 주요 함수
    1. debounce(func, wait)
       • 연속 호출 시 마지막 호출만 wait(ms) 이후 실행
       • 필요 이유: 사용자의 빠른 입력, 스크롤·resize 이벤트 등 빈번한 호출을 제어하여 성능 최적화
    2. throttle(func, wait)
       • 연속 호출 시 일정 간격(간격당 1회)으로만 실행
       • 예: 스크롤 핸들러, 마우스 이동 이벤트 제어
    3. cloneDeep(value)
       • 객체/배열을 재귀적으로 깊은 복사하여 참조 분리
       • 중첩된 구조를 안전하게 복제할 때 사용
    4. chunk(array, size)
       • 배열을 size 길이의 그룹(청크)으로 분할
    5. uniq(array)
       • 배열 내 중복 요소 제거
-->
<script setup>
import { ref, computed } from 'vue'
import { debounce, throttle, cloneDeep, chunk, uniq } from 'lodash-es'

// 예제 데이터 설정
const items = ref([1, 2, 3, 4, 5, 6, 7, 8, 9])
const dupArray = ref(['apple','banana','apple','orange','banana'])

// 1) Debounce: 사용자 입력 지연 처리
const input = ref('')
const debouncedInput = ref('')
const updateDebounce = debounce((val) => {
  debouncedInput.value = val
}, 500)
function onInput(event) {
  input.value = event.target.value
  updateDebounce(input.value)
}

// 2) Throttle: 스크롤 위치 출력 제한
const scrollPos = ref(0)
const updateScroll = throttle(() => {
  scrollPos.value = window.scrollY
}, 300)
window.addEventListener('scroll', updateScroll)

// 3) cloneDeep: 중첩 객체 깊은 복사 예제
const originalObj = ref({ a: 1, b: { c: 2 } })
const clonedObj = ref(cloneDeep(originalObj.value))

// 4) Chunk: 배열 청크 분할
const chunkSize = ref(3)
const chunked = computed(() => chunk(items.value, chunkSize.value))

// 5) Uniq: 배열 중복 제거
const uniqueArray = computed(() => uniq(dupArray.value))
</script>

<template>
  <div class="card-container">
    <div class="ui-card">
      <h3>Lodash-es 주요 기능 예제</h3>

      <!-- Debounce 예제 -->
      <div class="example-section">
        <label>
          Debounce Input (0.5초 지연):
          <input type="text" @input="onInput" placeholder="빠른 입력 제어" />
        </label>
        <p>Debounced Value: {{ debouncedInput }}</p>
      </div>

      <!-- Throttle 예제 -->
      <div class="example-section">
        <p>스크롤 위치 (300ms 간격): {{ scrollPos }}</p>
      </div>

      <!-- cloneDeep 예제 -->
      <div class="example-section">
        <p>원본 객체: {{ originalObj }}</p>
        <p>깊은 복사 객체: {{ clonedObj }}</p>
      </div>

      <!-- Chunk 예제 -->
      <div class="example-section">
        <label>
          Chunk Size:
          <input type="number" v-model.number="chunkSize" min="1" />
        </label>
        <ul>
          <li v-for="(group, idx) in chunked" :key="idx">
            그룹 {{ idx + 1 }}: {{ group }}
          </li>
        </ul>
      </div>

      <!-- Uniq 예제 -->
      <div class="example-section">
        <p>원본 배열: {{ dupArray }}</p>
        <p>중복 제거 결과: {{ uniqueArray }}</p>
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
  display: block;
  font-weight: 600;
  margin-bottom: 8px;
}
.example-section input[type="number"],
.example-section input[type="text"] {
  margin-left: 8px;
  padding: 4px 8px;
  border: 1px solid #dcdfe6;
  border-radius: 4px;
}
ul {
  list-style: none;
  padding: 0;
}
li {
  margin: 4px 0;
}
</style>