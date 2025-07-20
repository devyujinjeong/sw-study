package com.dbwls.cqrs.common.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Pagination {
    // 페이징 처리를 위해 존재하는 부분
    private final int currentPage;
    private final int totalPages;
    private final long totalItems;

}
