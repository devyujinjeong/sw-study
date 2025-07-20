package com.dbwls.cqrs.product.command.application.controller;

import com.dbwls.cqrs.common.dto.ApiResponse;
import com.dbwls.cqrs.product.command.application.dto.request.ProductCreateRequest;
import com.dbwls.cqrs.product.command.application.dto.request.ProductUpdateRequest;
import com.dbwls.cqrs.product.command.application.dto.response.ProductCommandResponse;
import com.dbwls.cqrs.product.command.application.service.ProductCommandService;
import com.dbwls.cqrs.product.query.dto.response.ProductListResponse;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class ProductCommandController {

    private final ProductCommandService productCommandService;

    @PostMapping("/products")
    public ResponseEntity<ApiResponse<ProductCommandResponse>> createProduct(
            @RequestPart @Validated ProductCreateRequest productCreateRequest,
            @RequestPart MultipartFile productImg
    ) {
        Long productCode = productCommandService.createProduct(productCreateRequest, productImg);

        ProductCommandResponse response = ProductCommandResponse.builder()
                .productCode(productCode)
                .build();

        return ResponseEntity
                .status(HttpStatus.CREATED).body(ApiResponse.success(response));

    }

    @PutMapping("/products/{productCode}")
    public ResponseEntity<ApiResponse<Void>> updateProduct(
            @PathVariable Long productCode,
            @RequestPart @Validated ProductUpdateRequest productUpdateRequest,
            @RequestPart(required = false) MultipartFile productImg
    ) {

        productCommandService.updateProduct(productCode, productUpdateRequest, productImg);

        ProductCommandResponse response = ProductCommandResponse.builder()
                .productCode(productCode)
                .build();

        return ResponseEntity
                .ok(ApiResponse.success(null));
    }

    @DeleteMapping("/products/{productCode}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long productCode) {

        productCommandService.deleteProduct(productCode);

        return ResponseEntity.ok(ApiResponse.success(null));
    }


}