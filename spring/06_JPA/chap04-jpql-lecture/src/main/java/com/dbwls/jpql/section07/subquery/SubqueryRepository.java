package com.dbwls.jpql.section07.subquery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubqueryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /* 서브 쿼리 이용하기 */
    /* 엔티티의 별칭을 반드시 사용해야 한다. */
    public List<Menu> selectWithSubQuery(String categoryName){
        String jpql = "SELECT m FROM Section07Menu m WHERE m.categoryCode = (" +
                "SELECT c.categoryCode FROM Section07Category c " +
                "WHERE c.categoryName = :categoryName)";

        return entityManager.createQuery(jpql,Menu.class)
                .setParameter("categoryName", categoryName)
                .getResultList();
    }
}
