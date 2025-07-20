package com.dbwls.jpql.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleJPQLRepository {
    @PersistenceContext
    private EntityManager entityManager;

    // 1. 타입이 지정되어 있는 경우 : TypedQuery를 사용하며, 어떤 타입으로 반환될 것인지
    public String selectSingleMenuByTypedQuery() {
        // 별칭을 만드시 사용해야 한다.
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = 8";
        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
        // 반드시 1개의 값만 반환해야 한다.
        String resultMenuName = query.getSingleResult();
        return resultMenuName;
    }

    // 2. 타입이 지정되어 있지 않는 경우 : Object를 이용
    public Object selectSingleMenuByQuery() {
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = 8";
        Query query = entityManager.createQuery(jpql);
        Object resultMenuName = query.getSingleResult();
        return resultMenuName;
    }

    // 3. 타입이 지정되는 경우 단일행 조회
    public Menu selectSingleRowMenuByTypedQuery() {
        // menu라는 엔티티 그 자체를 조회한다는 의미임
        String jpql = "SELECT m FROM Section01Menu as m WHERE m.menuCode = 8";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        // 하나의 행만 반환됨
        Menu resultMenu = query.getSingleResult();
        return resultMenu;
    }

    // 4. Menu 엔티티 여러 개 조회하기
    public List<Menu> selectMultiRowMenuByTypedQuery() {
        String jpql = "SELECT m FROM Section01Menu m";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);

        // 여러 개를 조회하기 때문에 List 타입으로 반환한다.
        List<Menu> menuList = query.getResultList();
        return menuList;
    }

    /* 5. tbl_menu의 categoryCode 중복 없이 조회 : distinct 사용 */
    public List<Integer> selectUsingDistinct(){
        String jpql = "SELECT DISTINCT m.categoryCode FROM Section01Menu m";
        TypedQuery<Integer> query = entityManager.createQuery(jpql, Integer.class);

        List<Integer> menuCategory = query.getResultList();
        return menuCategory;

    }

    /* 6. tbl_menu의 11,12 카테고리 코드를 가진 메뉴 목록 조회 : in 사용하기*/
    public List<Menu> selectUsingIn(){
        String jpql = "SELECT m FROM Section01Menu m WHERE m.categoryCode in(11,12) ";
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);

        List<Menu> menuList = query.getResultList();
        return menuList;
    }

    /* 7. tbl_menu의 "마늘"이 메뉴명에 포함 된 메뉴 목록 조회 : like 사용하기 */
    public List<Menu> selectUsingLike(){
        String jpql = "SELECT m FROM Section01Menu m WHERE m.menuName like '%마늘%'";

        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class).getResultList();
        return menuList;
    }
}
