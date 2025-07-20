package com.dbwls.jpql.section06.join;

import jakarta.persistence.*;

@Entity(name="Section06Menu")
@Table(name="tbl_menu")
public class Menu {
    @Id
    private int menuCode;
    private String menuName;
    private int menuPrice;

    /* Menu가 categoryCode를 가지고 있기 때문에 여기가 진짜 연관관계이다. */
    @ManyToOne
    /* 어떤 컬럼으로 조인할 것인지? */
    @JoinColumn(name = "categoryCode") // 진짜 연관관계
    private Category category;
    private String orderableStatus;

    public Menu() {}
}