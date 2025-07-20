<!--
  Validation Library: vee-validate + Yup
  - vee-validate (Vue 전용 유효성 검사)
    • Composition API 기반 폼 유효성 검사 프레임워크
    • 주요 컴포넌트/함수
      - Form, Field, ErrorMessage 컴포넌트
      - useForm(), useField(), useFieldArray(), validate(), resetForm() 등
      - validationSchema 속성으로 Yup 스키마 연결
    • 사용법
      1) Form 컴포넌트에 `:validation-schema` 또는 `handleSubmit` 사용
      2) Field 단위로 `v-model` 바인딩 후 유효성 검사 트리거 설정
      3) submit 시 `formRef.value.validate()` 또는 `handleSubmit` 호출
  - Yup (JavaScript 스키마 빌더)
    • 개념: 직관적인 체이닝 API로 스키마 정의 및 검증 실행
    • 주요 함수
      - yup.object(), yup.string(), yup.number(), yup.array() 등 타입 빌더
      - .required(), .email(), .min(), .max(), .matches(), .test() 등 메서드
      - schema.validate(), schema.validateAt(), schema.isValid(), schema.cast() 등
-->
<template>
  <el-row justify="center" style="margin-top: 20px;">
    <el-col :span="16">
      <el-card class="ui-card">
        <template #header>
          <span>ValidationForm 예제</span>
        </template>
        <el-form
            :model="form"
            :rules="rules"
            ref="formRef"
            label-position="top"
            class="validation-form"
        >
          <el-form-item label="이메일" prop="email">
            <el-input v-model="form.email" placeholder="이메일 입력" />
          </el-form-item>

          <el-form-item label="비밀번호" prop="password">
            <el-input v-model="form.password" type="password" placeholder="비밀번호 입력" />
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="submitForm">제출</el-button>
            <el-button @click="resetForm">초기화</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </el-col>
  </el-row>
</template>

<script setup>
import { reactive, ref } from 'vue'
import * as yup from 'yup'

// 폼 요소 참조
const formRef = ref(null)

// reactive로 form 데이터 정의
const form = reactive({
  email: '',
  password: ''
})

// yup 스키마 정의
const schema = yup.object({
  email: yup
      .string()
      .email('유효한 이메일 형식이 아닙니다.')
      .required('이메일은 필수 입력입니다.'),
  password: yup
      .string()
      .min(6, '비밀번호는 최소 6자 이상이어야 합니다.')
      .required('비밀번호는 필수 입력입니다.')
})

// ElementPlus rules에 yup 검증 래핑
const rules = {
  email: [{ validator: (_rule, value, callback) => {
      schema.validateAt('email', { email: value })
          .then(() => callback())
          .catch(err => callback(new Error(err.message)))
    }, trigger: 'blur' }],
  password: [{ validator: (_rule, value, callback) => {
      schema.validateAt('password', { password: value })
          .then(() => callback())
          .catch(err => callback(new Error(err.message)))
    }, trigger: 'blur' }]
}

// 제출 핸들러
const submitForm = () => {
  formRef.value.validate(valid => {
    if (valid) alert(`제출된 값: ${JSON.stringify(form)}`)
    else console.log('유효성 검사 실패')
  })
}

// 초기화 핸들러
const resetForm = () => formRef.value.resetFields()
</script>

<style scoped>
.ui-card {
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  box-shadow: var(--el-box-shadow-2);
  border: 1px solid #ebeef5;
}
.validation-form {
  margin-top: 20px;
}
</style>