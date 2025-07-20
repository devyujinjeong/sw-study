package com.dbwls.cqrs.product.query.service;

import com.dbwls.cqrs.common.dto.Pagination;
import com.dbwls.cqrs.exception.BusinessException;
import com.dbwls.cqrs.exception.ErrorCode;
import com.dbwls.cqrs.product.query.dto.request.ProductSearchRequest;
import com.dbwls.cqrs.product.query.dto.response.ProductDTO;
import com.dbwls.cqrs.product.query.dto.response.ProductDetailResponse;
import com.dbwls.cqrs.product.query.dto.response.ProductListResponse;
import com.dbwls.cqrs.product.query.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductQueryService {
    private final ProductMapper productMapper;

    /* 상품 상세 조회 */
    @Transactional(readOnly = true)
    public ProductDetailResponse getProduct(Long productCode) {

        // null값이 있는 경우에 예외를 발생시킴
        ProductDTO product = Optional.ofNullable(
                productMapper.selectProductByCode(productCode)
        ).orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));

        return ProductDetailResponse.builder()
                .product(product)
                .build();
    }

    /* 상품 리스트 조회 */
    @Transactional(readOnly = true)
    public ProductListResponse getProducts(ProductSearchRequest productSearchRequest){

        // 잘라서 보여줘야 하는 컨텐츠만 제공하고 있음
        List<ProductDTO> products = productMapper.selectProducts(productSearchRequest);

        // 해당 검색 조건으로 총 몇개의 컨텐츠가 있는지 조회 (페이징을 위한 속성 값 계산이 필요)
        long totalItems = productMapper.countProducts(productSearchRequest);

        int page = productSearchRequest.getPage();
        int size = productSearchRequest.getSize();


        return ProductListResponse.builder()
                .products(products)
                .pagination(Pagination.builder()
                        .currentPage(page)
                        .totalPages((int)Math.ceil((double)totalItems/size))
                        .totalItems(totalItems)
                        .build())
                .build();
    }
}
