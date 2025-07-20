package com.dbwls.jpql.section07.subquery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SubqueryRepositoryTest {

    @Autowired
    private SubqueryRepository subqueryRepository;

//    @DisplayName("subquery 테스트")
//    @Test
//    void testSelectWithSubQuery(){
//        String categoryName = "한식";
//        List<Menu> menuList = subqueryRepository.selectWithSubQuery(categoryName);
//        assertNotNull(menuList);
//        menuList.forEach(System.out::println);
//    }

    @DisplayName("subquery 테스트")
    @ParameterizedTest
    @CsvSource({"한식"})
    void testSelectWithSubQuery(String categoryName){
        List<Menu> menuList = subqueryRepository.selectWithSubQuery(categoryName);
        assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }
}