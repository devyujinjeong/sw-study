package com.dbwls.section01.scope.subsection01.singleton;

import com.dbwls.common.Beverage;
import com.dbwls.common.Bread;
import com.dbwls.common.Product;
import com.dbwls.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

public class ContextConfiguration {
    // @Bean : 빈 등록하기
    @Bean
    public Product carpBread() {
        System.out.println("붕어빵 생성 시점");
        return new Bread("붕어빵", 1000, new java.util.Date()); // 생성자 주입 (의존성 주입)
    }
    @Bean
    // 나열한 빈 인스턴스가 모두 생성 된 뒤 생성 되도록
    // 만약 이렇게 명시한 빈 중 하나라도 생성되지 않으면, cart는 생성되지 않고,
    // BeanCreationException라는 예외가 발생하게 된다.
    @DependsOn({"carpBread", "milk", "water"})
    @Lazy // 컨테이너 동작 시점이 아니라 해당 객체 필요 시점에 인스턴스를 생성함
    @Scope("singleton") //기본값
    public ShoppingCart cart() {
        System.out.println("쇼핑 카트 생성 시점");
        return new ShoppingCart();
    }
    @Bean
    public Product milk() {
        System.out.println("딸기우유 생성 시점");
        return new Beverage("딸기우유", 1500, 500);
    }
    @Bean
    public Product water() {
        System.out.println("물 생성 시점");
        return new Beverage("지리산암반수", 3000, 500);
    }

}

