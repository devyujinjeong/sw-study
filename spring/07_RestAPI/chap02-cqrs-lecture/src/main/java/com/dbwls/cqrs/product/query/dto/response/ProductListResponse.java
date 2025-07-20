package com.dbwls.cqrs.product.query.dto.response;

import com.dbwls.cqrs.common.dto.Pagination;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductListResponse {
    private final List<ProductDTO> products;
    private final Pagination pagination;
}
