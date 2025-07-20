import axios from "axios";

const api = axios.create({
    baseURL : 'http://localhost:8080'
});

/* 상품 목록 조회 api */
/* 쿼리 파라미터를 함께 넘겨주는 구조 */
export const getProducts = params => api.get("/products", { params })

/* 특정 상품 상세 조회 api */
/* PathVariable 를 넘겨주는 구조 */
export const getProduct = id => api.get(`/products/${id}`)

/* 특정 상품 삭제 요청 api */
export const deleteProduct = id => api.delete(`/products/${id}`)

/* 상품 등록 api */
/* FormData로 파일과 JSON을 보내는 경우*/
export const createProduct = ( {payload, file} )=> {
    const formData = new FormData();

    formData.append(
        'productCreateRequest',
        // json 형태의 문자열로 넣어준 것임
        new Blob([JSON.stringify(payload)], {type : 'application/json'})
    );

    formData.append('productImg', file);

    return api.post(`/products`, formData, {
        headers: {
            'Content-Type' : 'multipart/form-data'
        }
    })
}

/* 상품 수정 api */
export const updateProduct = ( {id, payload, file} )=> {
    const formData = new FormData();
    formData.append(
        'productUpdateRequest',
        // json 형태의 문자열로 넣어준 것임
        new Blob([JSON.stringify(payload)], {type : 'application/json'})
    );

    formData.append('productImg', file);

    return api.put(`/products/${id}`, formData, {
        headers: {
            'Content-Type' : 'multipart/form-data'
        }
    })
}