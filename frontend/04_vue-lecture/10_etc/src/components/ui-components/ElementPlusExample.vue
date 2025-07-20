<!--
  UI Component Library: Element Plus
  - Vue 3 프로젝트에서 빠르게 일관된 디자인의 UI를 구성할 수 있는 컴포넌트 모음
  - 주요 컴포넌트 종류
    • Layout: el-row, el-col
    • Container: el-card, el-space
    • Data Entry: el-input, el-select, el-option, el-button
    • Data Display: el-table, el-table-column
    • Navigation: el-pagination
    • Feedback: el-dialog, el-dropdown, el-tooltip, el-loading
  - 사용법
    1) npm install element-plus
    2) main.js 에서 import 및 등록
       import ElementPlus from 'element-plus';
       import 'element-plus/dist/index.css';
       app.use(ElementPlus);
    3) 컴포넌트 내부에서 <el-*> 태그 형태로 사용
  - 다른 UI 컴포넌트 라이브러리
    • Vuetify
    • Ant Design Vue
    • Naive UI
    • PrimeVue
-->
<script setup>
import { ref, computed } from 'vue';

const inputValue    = ref('');
const selected      = ref(null);
const multiSelected = ref([]);
const dialogVisible = ref(false);

const tableData = ref([
  { date: '2025-01-01', name: '김철수', address: 'Seoul' },
  { date: '2025-01-02', name: '이영희', address: 'Busan' },
  { date: '2025-01-03', name: '박민수', address: 'Daegu' },
  { date: '2025-01-04', name: '최지우', address: 'Incheon' },
  { date: '2025-01-05', name: '정하늘', address: 'Gwangju' },
  { date: '2025-01-06', name: '오세훈', address: 'Daejeon' },
  { date: '2025-01-07', name: '유나',   address: 'Ulsan' },
  { date: '2025-01-08', name: '강민',   address: 'Jeju' },
  { date: '2025-01-09', name: '한소희', address: 'Suwon' },
  { date: '2025-01-10', name: '임수정', address: 'Changwon' }
])

const currentPage = ref(1);
const pageSize    = ref(5);
const pagedData   = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value;
  return tableData.value.slice(start, start + pageSize.value);
});
function handlePageChange(page) {
  currentPage.value = page;
}
</script>

<template>
  <el-row justify="center" style="margin-top: 20px;">
    <el-col :span="16">
      <el-card class="ui-card">
        <template #header>
          <span>Element Plus 주요 컴포넌트 예제</span>
        </template>

        <el-space direction="vertical" :size="20">
          <el-space :size="10">
            <el-button type="primary">Primary</el-button>
            <el-button type="success">Success</el-button>
            <el-button type="warning">Warning</el-button>
            <el-button type="danger">Danger</el-button>
          </el-space>

          <el-space direction="vertical" :size="10">
            <el-input v-model="inputValue" clearable placeholder="Clearable input" />
            <el-input v-model="inputValue" placeholder="With prefix">
              <template #prefix>
                <i class="el-icon-search"></i>
              </template>
            </el-input>
            <el-input placeholder="Disabled input" disabled />
          </el-space>

          <el-space direction="vertical" :size="10">
            <el-select v-model="selected" filterable placeholder="Single select">
              <el-option label="Option A" value="A" />
              <el-option label="Option B" value="B" />
            </el-select>
            <el-select
                v-model="multiSelected"
                multiple
                filterable
                clearable
                collapse-tags
                collapse-tags-tooltip
                :max-collapse-tags="2"
                placeholder="Multi select"
                style="width: 240px;"
            >
              <el-option label="Tag1" value="tag1" />
              <el-option label="Tag2" value="tag2" />
              <el-option label="Tag3" value="tag3" />
            </el-select>
          </el-space>

          <el-table :data="pagedData" stripe border>
            <el-table-column prop="date"  label="날짜" width="120" />
            <el-table-column prop="name"  label="이름" />
            <el-table-column prop="address" label="주소" />
          </el-table>
          <div style="text-align: right; margin-top: 10px;">
            <el-pagination
                background
                layout="prev, pager, next, jumper"
                :page-size="pageSize"
                :total="tableData.length"
                v-model:current-page="currentPage"
                @current-change="handlePageChange"
            />
          </div>

          <el-button type="primary" @click="dialogVisible = true">
            Open Dialog
          </el-button>
          <!-- 수정: plain v-model -->
          <el-dialog v-model="dialogVisible" title="Sample Dialog">
            <p>Dialog Content</p>
            <template #footer>
              <el-button @click="dialogVisible = false">Cancel</el-button>
              <el-button type="primary" @click="dialogVisible = false">
                Confirm
              </el-button>
            </template>
          </el-dialog>
        </el-space>
      </el-card>
    </el-col>
  </el-row>
</template>

<style scoped>
:root {
  --el-box-shadow-2: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.ui-card {
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  box-shadow: var(--el-box-shadow-2);
}
</style>
