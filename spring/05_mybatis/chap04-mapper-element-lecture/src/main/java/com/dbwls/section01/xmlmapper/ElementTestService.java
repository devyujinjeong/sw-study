package com.dbwls.section01.xmlmapper;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.dbwls.common.Template.getSqlSession;

public class ElementTestService {
    public void selectResultMapTest() {
        SqlSession sqlSession = getSqlSession();
        ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapTest();

        if(menuList!=null && !menuList.isEmpty()){
            menuList.forEach(System.out::println);
        }else{
            System.out.println("조회 결과 없음");
        }

        sqlSession.close();
    }

    public void selectResultMapAssociationTest() {
        SqlSession sqlSession = getSqlSession();
        ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<MenuAndCategoryDTO> menuList = mapper.selectResultMapAssociationTest();

        if(menuList!=null && !menuList.isEmpty()){
            menuList.forEach(System.out::println);
        }else{
            System.out.println("조회 결과 없음");
        }

        sqlSession.close();
    }

    public void selectResultMapCollectionTest() {
        SqlSession sqlSession = getSqlSession();
        ElementTestMapper mapper = sqlSession.getMapper(ElementTestMapper.class);

        List<CategoryAndMenuDTO> menuCategoryList = mapper.selectResultMapCollectionTest();

        if(menuCategoryList!=null && !menuCategoryList.isEmpty()){
            menuCategoryList.forEach(System.out::println);
        }else{
            System.out.println("조회 결과 없음");
        }

        sqlSession.close();
    }
}
