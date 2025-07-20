<!--
  Chart Library: vue-chartjs + Chart.js
  - Chart.js 기반 Vue 컴포넌트 래퍼
  - 주요 사용법
    1) ChartJS.register(Scales, Elements, Plugins...)
    2) <Bar :data="data" :options="options" /> 등으로 차트 렌더링
  - 설치: npm install vue-chartjs chart.js
-->
<script setup>
import { ref } from 'vue'
import { Bar, Line } from 'vue-chartjs'
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
} from 'chart.js'

// Chart.js 컴포넌트 등록
ChartJS.register(CategoryScale, LinearScale, BarElement, PointElement, LineElement, Title, Tooltip, Legend)

// Bar 차트 데이터 및 옵션
const barData = ref({
  labels: ['Jan','Feb','Mar','Apr','May','Jun'],
  datasets: [{ label: 'Sales', data: [30,70,50,90,120,80], backgroundColor: '#409eff' }]
})
const barOptions = ref({ responsive: true, plugins: { legend: { position: 'top' } } })

// Line 차트 데이터 및 옵션
const lineData = ref({
  labels: ['Mon','Tue','Wed','Thu','Fri','Sat','Sun'],
  datasets: [{ label: 'Visitors', data: [50,60,70,80,90,100,110], borderColor: '#67c23a', fill: false }]
})
const lineOptions = ref({ responsive: true, plugins: { legend: { position: 'top' } } })
</script>

<template>
  <div class="card-container">
    <div class="ui-card">
      <h3>차트 예제 (Bar & Line)</h3>

      <div class="example-section">
        <h4>Bar Chart</h4>
        <Bar :data="barData" :options="barOptions" />
      </div>

      <div class="example-section">
        <h4>Line Chart</h4>
        <Line :data="lineData" :options="lineOptions" />
      </div>
    </div>
  </div>
</template>

<style scoped>
.card-container { display: flex; justify-content: center; margin: 20px 0; }
.ui-card { width: 100%; max-width: 800px; padding: 20px; border: 1px solid #ebeef5; box-shadow: 0 2px 12px rgba(0,0,0,0.1); border-radius: 8px; background: #fff; }
.ui-card h3 { margin-bottom: 16px; font-size: 1.25rem; }
.example-section { margin-bottom: 24px; }
.example-section h4 { margin-bottom: 8px; font-size: 1rem; }
</style>
