package com.dbwls.cqrs.product.query.controller;

import com.dbwls.cqrs.common.dto.ApiResponse;
import com.dbwls.cqrs.product.query.dto.request.ProductSearchRequest;
import com.dbwls.cqrs.product.query.dto.response.ProductDetailResponse;
import com.dbwls.cqrs.product.query.dto.response.ProductListResponse;
import com.dbwls.cqrs.product.query.service.ProductQueryService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
* ViewResolver를 거치지 않는 컨트롤러라고 생각하면 된다.
* 모든 핸들러 메소드에 @ResponseBody가 적용된 것과 같다.
*/
@RestController
// 생성자 주입을 코드없이 자동으로 설정해주는 어노테이션
@RequiredArgsConstructor
public class ProductQueryController {

    private final ProductQueryService productQueryService;

    @GetMapping("/products/{productCode}")
    public ResponseEntity<ApiResponse<ProductDetailResponse>> getProduct(@PathVariable Long productCode){
        ProductDetailResponse response = productQueryService.getProduct(productCode);

        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping("/products")
    public ResponseEntity<ApiResponse<ProductListResponse>> getProducts(
            ProductSearchRequest productSearchRequest
    ){
        ProductListResponse response = productQueryService.getProducts(productSearchRequest);

        return ResponseEntity.ok(ApiResponse.success(response));
    }

}
