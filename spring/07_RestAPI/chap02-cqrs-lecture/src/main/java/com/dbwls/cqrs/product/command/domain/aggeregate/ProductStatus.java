package com.dbwls.cqrs.product.command.domain.aggeregate;

public enum ProductStatus {
    USABLE,     // 주문 가능
    DISABLE,    // 주문 불가
    DELETED     // 삭제 (soft delete)
}
