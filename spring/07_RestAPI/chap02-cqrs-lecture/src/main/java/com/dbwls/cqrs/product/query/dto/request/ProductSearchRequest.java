package com.dbwls.cqrs.product.query.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearchRequest { // 검색 및 페이징 처리
    private Integer page = 1;
    private Integer size = 10;
    private Long categoryCode;
    private String productName;

    public int getOffset(){
        return (page-1) * size;
    }

    public int getLimit(){
        return size;
    }

}
