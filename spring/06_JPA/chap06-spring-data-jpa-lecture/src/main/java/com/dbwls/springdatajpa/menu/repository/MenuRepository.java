package com.dbwls.springdatajpa.menu.repository;

import com.dbwls.springdatajpa.menu.dto.MenuProjection;
import com.dbwls.springdatajpa.menu.entity.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/* 내가 사용하는 엔티티와 그 엔티티의 아이디가 제네릭 타입으로 들어가야 한다. */
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    /* 메뉴 코드를 기준으로 내림차순 정렬한 DTO 프로젝션 반환 메소드 */
    List<MenuProjection> findAllByOrderByMenuCodeDesc();

    /* 전달 받은 가격을 초과하는 메뉴 목록 조회 */
    List<Menu> findByMenuPriceIsGreaterThan(Integer menuPrice);

    /* 전달 받은 가격을 초과하는 메뉴 목록 조회 + 가격 오름차순 조회 */
    List<Menu> findByMenuPriceIsGreaterThanOrderByMenuPrice(Integer menuPrice);

    /* 전달 받은 가격을 초과하는 메뉴 목록 조회 + 전달 받은 정렬 기준*/
    List<Menu> findByMenuPriceIsGreaterThan(Integer menuPrice, Sort sort);
}
