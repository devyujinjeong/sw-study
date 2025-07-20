package com.dbwls.springdatajpa.menu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_menu")
@Getter
/* 엔티티는 값을 변경하면 DB에 반영되는 것이므로 조심하기 ^^ */
/* Setter는 지양하는 것이 좋음
* : 객체를 언제든지 변경할 수 있는 상태가 되므로 객체의 안전성이 보장 되지 않을 수 있다.
* 단, 값 변경이 필요한 경우에는 해당 비즈니스 로직에 맞는 명확한 목적의 기능 메소드를 정의한다.
* */
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
/* 기본 생성자가 필요하지만 접근 제한을 걸어 외부에서 무문별하게 엔티티 객체를 생성하는 것을 지양한다.
* @AllArgsConstructor 지양 : 인스턴스 선언 순서에 영향을 받으므로 변수 순선 변경 시
* 입력 값 순서도 바뀌므로 검출하기 힘든 오류 발생 가능성이 있다. */
/* @ToString : 사용 시 연관 관계 매핑 필드는 제거한다. */
@Builder // 빌더 패턴은 밑에 있는 어노테이션을 사용해야 함
@AllArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    public void modifyMenuName(String menuName){
        this.menuName = menuName;
    }
}
