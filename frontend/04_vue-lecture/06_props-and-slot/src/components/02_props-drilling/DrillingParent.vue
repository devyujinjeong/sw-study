<script setup>
import {provide, readonly, ref} from "vue";
import DrillingChiild from "@/components/02_props-drilling/DrillingChiild.vue";

/* Props Drilling : 상위 컴포넌트에서 하위 컴포넌트로 전달 하는 과정에서
* 여러 컴포넌트를 거치면 코드가 복잡해지고 유지보수가 어려워 진다.
* provide : 하위 컴포넌트에서 사용할 수 있는 값을 제공한다.
* inject : provide에서 제공 된 값을 꺼내서 사용한다.
* 단, 값 변경 추적이 어려울 수 있으므로 readOnly 옵션을 고려한다. */
const count = ref(1);

// 이렇게 작성하면 자식 쪽에서 값을 변경할 수 있고 값을 볼 수 있다.
// provide('count', count);

// 이렇게 작성하면 readonly 속성으로 인해 값을 변경할 수 없다.
provide('count', readonly(count));
</script>

<template>
  <div class="container">
    <h1>Parent : {{ count }}</h1>
    <DrillingChiild/>
  </div>
</template>

<style scoped>

</style>