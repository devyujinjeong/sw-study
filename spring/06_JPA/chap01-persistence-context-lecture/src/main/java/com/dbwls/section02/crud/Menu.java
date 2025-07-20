package com.dbwls.section02.crud;

import jakarta.persistence.*;

/* bean 이름이 중복되면 안되는 것 처럼 entity이름도 중복되면 안된다. */
@Entity(name = "Section02Menu") // 기본 이름은 클래스명이며 중복 되면 안되므로 명시함
@Table(name = "tbl_menu") // 이 엔티티가 어떤 테이블과 매핑되는 엔티티인지 적어줌
public class Menu {

    @Id // PK를 표기해주는 것으로 필수적으로 해야 한다.
    @Column(name = "menu_code") // 테이블과 엔티티 매핑해주기
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_price")
    private int menuPrice;
    @Column(name = "category_code")
    private int categoryCode;
    @Column(name = "orderable_status")
    private String orderableStatus;


    public Menu(String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public Menu() {}

    public int getMenuCode() {
        return menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName){
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
