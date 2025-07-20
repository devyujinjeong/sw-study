<script setup>
import {reactive, ref} from "vue";

import SlotChild from "@/components/03_slot/SlotChild.vue";
import NamedSlotChild from "@/components/03_slot/NamedSlotChild.vue";
import DynamicSlotChild from "@/components/03_slot/DynamicSlotChild.vue";

const slotData = ref('');
const obj = reactive({
  name : 'Vue',
  founder : 'Evan Yu',
  img : 'https://an2-img.amz.wtchn.net/image/v2/UWwxOCgg6_f8pjTdImIwcQ.webp?jwt=ZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKdmNIUnpJanBiSW1SZk1USTRNSGczTWpCeE9EQWlYU3dpY0NJNklpOTJNaTl6ZEc5eVpTOXBiV0ZuWlM4eE5qRTFOemszTmpRek5URTJNREl5TXpReUluMC54ekhUMUVnNmhhVnduM1VKcFI3Q2dtUjdwcnk1NTFwNHBVM1pBOVdpVjlB'
});
const dynamicName = ref('동서남북');
</script>

<template>
  <div class="container">
    <h1>Parent</h1>
    slot data 변경 : <input type="text" v-model="slotData">
    <SlotChild>
      <h3>{{ slotData }}</h3>
    </SlotChild>

  <!--
    Slot의 name 속성 활용하기
  -->
    <NamedSlotChild>
      <!-- 슬롯에 이름 붙이기 -->
      <template v-slot:name>
        <p>name : {{ obj.name }}</p>
      </template>
      <template v-slot:founder>
        <p>founder : {{ obj.founder }}</p>
      </template>
      <template v-slot:img>
        <img :src="obj.img" :alt="obj.name">
      </template>
    </NamedSlotChild>

    <h1>Dynamic Slot</h1>
    <input type="text" v-model="dynamicName">
    <DynamicSlotChild>
      <!--
        #[dynamicName] : Vue 3에서 지원하는 v-slot:[dynamicName]의 축약 문법
        입력 된 dynamicName 값이 속성 이름과 일치할 대 해당 slot이 렌더링 된다.
       -->
      <template #[dynamicName]>
        {{ dynamicName }} : 입력된 값이 slot의 name과 일치할 때 나타남
      </template>
    </DynamicSlotChild>
  </div>
</template>

<style scoped>
img {
  width: 200px;
  height: 200px;
}

</style>