<script setup>
</script>

<template>
  <div class="text-center">
    <h1>Welcome to My App</h1>
    <p class="lead">Explore our products and more!</p>
    <!-- 어떤 링크로 넘어갈지 설정해주는 것 -->
    <RouterLink to="/products" class="btn btn-primary">Go to Products</RouterLink>
  </div>
</template>

<style scoped>
.text-center {
  margin-top: 50px;
}
</style>