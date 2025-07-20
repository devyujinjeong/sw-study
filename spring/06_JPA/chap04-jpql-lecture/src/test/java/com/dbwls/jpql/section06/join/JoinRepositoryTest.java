package com.dbwls.jpql.section06.join;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JoinRepositoryTest {

    @Autowired
    private JoinRepository joinRepository;

    @DisplayName("inner join 테스트")
    @Test
    void testSelectByInnerJoin(){
        List<Menu> menuList = joinRepository.selectByInnerJoin();

        assertNotNull(menuList);
    }

    @DisplayName("fetch join 테스트")
    @Test
    void testSelectByFetchJoin(){
        List<Menu> menuList = joinRepository.selectByFetchJoin();

        assertNotNull(menuList);
    }


    @DisplayName("Outer join 테스트")
    @Test
    void testSelectByOuterJoin(){
        List<Object[]> menuList = joinRepository.selectByOuterJoin();

        assertNotNull(menuList);
        menuList.forEach(
                row -> {
                    for(Object column : row) System.out.print(column + " ");
                    System.out.println();
                }
        );
    }

    @DisplayName("collection join 테스트")
    @Test
    void testSelectByCollectionJoin(){
        List<Object[]> menuList = joinRepository.selectByCollectionJoin();

        assertNotNull(menuList);
        menuList.forEach(
                row -> {
                    for(Object column : row) System.out.print(column + " ");
                    System.out.println();
                }
        );
    }

    /* cross join : 모든 조합을 조인하는 것 */
    @DisplayName("세타조인을 이용한 조회 테스트")
    @Test
    public void testSelectByThetaJoin() {
        //given
        //when
        List<Object[]> categoryList = joinRepository.selectByThetaJoin();

        //then
        Assertions.assertNotNull(categoryList);
        categoryList.forEach(
                row -> {
                    for(Object col : row) {
                        System.out.print(col + " ");
                    }
                    System.out.println();
                }
        );
    }
}