package com.dbwls.jpql.section02.parameter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParameterBindingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /* 1. 이름을 넘겨서 바인딩 하는 방법 - :원하는 이름  */
    public List<Menu> selectMenuByBindingName(String menuName){
        String jpql = "SELECT m FROM Section02Menu m WHERE m.menuName = :menuName";
        return entityManager.createQuery(jpql, Menu.class)
                // 이름을 통해서 파라미터를 set 하고 있음
                .setParameter("menuName", menuName)
                .getResultList();
    }

    /* 2. 위치를 통해 바인딩 하는 방법 : ?1 1번째 위치에 set해주기 */
    public List<Menu> selectMenuByBindingPosition(String menuName){
        String jpql = "SELECT m FROM Section02Menu m WHERE m.menuName = ?1";
        return entityManager.createQuery(jpql, Menu.class)
                // 위치를 통해서 파라미터 값을 진행해줌
                .setParameter(1, menuName)
                .getResultList();
    }

}
