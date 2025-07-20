package com.dbwls.jpql.section06.join;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity(name = "Section06Category")
@Table(name = "tbl_category")
public class Category {
    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

    /* 연관 관계 작성하기 */
    @OneToMany(mappedBy = "category")
    private List<Menu> menuList;
}
