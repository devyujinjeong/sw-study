<script setup>

import ProductList from "@/features/product/components/ProductList.vue";
import {onMounted, reactive, ref} from "vue";
import {getProducts} from "@/features/product/api.js";
import SkeletonList from "@/components/common/SkeletonList.vue";
import PagingBar from "@/components/common/PagingBar.vue";
import SerarchBar from "@/components/common/SerarchBar.vue";
import {useRouter} from "vue-router";

/* 관리해야 하는 상태값 */
const router = useRouter(); // 페이지 이동을 명령하는 객체이기 때문에 페이지 이동을 하려면 router가 필요하다.
const products = ref([]); // 상품 내역
const pagination = reactive({ // 페이지 처리를 위한 부분
  currentPage : 1,
  totalPages : 1,
  totalItems : 0
});
const searchParams = reactive({ // 검색 => 어떤 방식으로 검색할지?!
  categoryCode: null,
  productName : ''
})
const isLoading = ref(true); // 로딩 중인지 아닌지에 관한 정보

/* 함수 */
// async와 await를 통해 비동기 처리를 하는 것이다. (js의 문법)
const fetchProducts = async (page = 1) => {
  isLoading.value = true; // 로딩 중!!
  try {
    // api 호출 (axios lib)
    // 현재 우리는 ApiResponse 같은 것으로 감싸고 있다. 이 때, 데이터 구조를 잘 확인하고 데이터를 가져와야 한다.
    // data라는 변수를 wrapper라는 변수 이름으로 받는다. 즉, data의 별명을 지어주는 거라고 생각하면 된다.
    // getProducts에 파라미터 넘겨주기!!
    const { data : wrapper } = await getProducts({
      page,
      categoryCode : searchParams.categoryCode,
      productName : searchParams.productName
    });

    // 응답된 데이터
    const respData = wrapper.data;
    products.value = respData.products || []; // 빈 배열이라도 넣어서 에러가 나지 않게 방지하는 것?!! (by. chat gpt)
    // Object.assign(target, ...sources) : source의 속성을 모두 꺼내 target에 덮어쓰기
    //
    Object.assign(pagination, respData.pagination ?? {});
    isLoading.value = false; // 데이터가 요청된거면 즉, 보여진거면 로딩 중은 보이지 않아도 됨!
  } catch(e) {
    console.log('상품 목록 로드 실패', e);
  }
}

// 검색 이벤트 발생 시 수행할 함수
const onSearch = params => {
  Object.assign(searchParams, params);
  pagination.currentPage = 1;
  fetchProducts();
}

/* 상품 등록 이벤트 클릭이 되면 /products/new로 이동하게 됨*/
const goToProductCreate = () => router.push(`/products/new`)

onMounted(() => fetchProducts());
</script>
<template>
  <SerarchBar @search="onSearch"/>
  <!-- ProductList가 조회 되지 않았을 때 보여줄 뼈대 컴포넌트 -->
  <SkeletonList v-if="isLoading"/>
  <!-- ProdctList가 조회 되었을 때 보여줄 컴포넌트 -->
  <ProductList v-else :products="products"/>
  <PagingBar
      v-bind="pagination"
      @page-changed="fetchProducts"
  />
  <div class="action">
    <button @click="goToProductCreate">상품 등록</button>
  </div>
</template>
<style scoped>

</style>