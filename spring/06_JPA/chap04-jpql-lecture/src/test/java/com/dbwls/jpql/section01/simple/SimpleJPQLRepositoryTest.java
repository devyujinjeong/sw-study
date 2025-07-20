package com.dbwls.jpql.section01.simple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleJPQLRepositoryTest {

    @Autowired
    private SimpleJPQLRepository simpleJPQLRepository;

    @DisplayName("TypedQuery를 이용한 단일 컬럼 조회")
    @Test
    void selectSingleMenuByTypedQueryTest(){
        String menuName = simpleJPQLRepository.selectSingleMenuByTypedQuery();

        assertEquals("한우딸기국밥", menuName);

    }

    @DisplayName("Query를 이용한 단일 컬럼 조회")
    @Test
    void selectSingleMenuByQueryTest(){
        Object menuName = simpleJPQLRepository.selectSingleMenuByTypedQuery();

        assertEquals("한우딸기국밥", menuName);

    }

    @DisplayName("TypedQuery를 이용한 단일행 조회")
    @Test
    void selectSingleRowMenuByTypeddQuery(){
        Menu menu = simpleJPQLRepository.selectSingleRowMenuByTypedQuery();

        assertNotNull(menu);
        assertEquals("한우딸기국밥", menu.getMenuName());

    }

    @DisplayName("TypedQuery를 이용한 다중 행 조회")
    @Test
    void selectMultiRowMenuByTypedQuery(){
        List<Menu> allMenu = simpleJPQLRepository.selectMultiRowMenuByTypedQuery();

        assertNotNull(allMenu);
        assertEquals(27,allMenu.size());
    }

    /* 실습 테스트*/
    @DisplayName("CategoryCode 중복 없이 가져오기")
    @Test
    void selectUsingDistinct(){
        List<Integer> categoryCodeList = simpleJPQLRepository.selectUsingDistinct();

        assertNotNull(categoryCodeList);
        assertEquals(12,categoryCodeList.size());
    }

    @DisplayName("카테고리 코드가 11,12인 메뉴 가져오기")
    @Test
    void selectUsingIn(){
        List<Menu> allMenu = simpleJPQLRepository.selectUsingIn();

        assertNotNull(allMenu);
        assertEquals(4, allMenu.size());
    }

    @DisplayName("마늘이 포함되어 있는 메뉴 가져오기")
    @Test
    void selectUsingLike(){
        List<Menu> allMenu = simpleJPQLRepository.selectUsingLike();

        assertNotNull(allMenu);
        assertEquals(2, allMenu.size());
    }

}