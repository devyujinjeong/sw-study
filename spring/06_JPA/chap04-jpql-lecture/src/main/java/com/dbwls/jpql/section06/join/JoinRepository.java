package com.dbwls.jpql.section06.join;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JoinRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /* 1. inner join을 사용
    * 그냥 JOIN 사용하면 JPA의 N+1 문제가 발생한다. Lazy Loading이기 때문에 발생하는 현상임 */
    public List<Menu> selectByInnerJoin(){
        String jpql = "SELECT m FROM Section06Menu m JOIN m.category c";
        return entityManager.createQuery(jpql, Menu.class).getResultList();
    }

    /* 2. fetch를 이용해 위의 문제를 해결할 수 있다. */
    public List<Menu> selectByFetchJoin(){
        // fetch : JPQL에서 성능 최적화를 위해 사용하는 기능으로
        // 연관 엔터티나 컬렉션을 한 번에 조회한다.
        String jpql = "SELECT m FROM Section06Menu m JOIN FETCH m.category c";
        return entityManager.createQuery(jpql, Menu.class).getResultList();
    }

    /* 3. Outerjoin
    구문 조건 자체가 Lazy loading을 하지 않는 상태임*/
    public List<Object[]> selectByOuterJoin(){
        String jpql = "SELECT m.menuName, c.categoryName FROM Section06Menu m " +
                "RIGHT JOIN m.category c";
        return entityManager.createQuery(jpql).getResultList();
    }

    public List<Object[]> selectByCollectionJoin(){
        String jpql = "SELECT c.categoryName, m.menuName FROM Section06Category c " +
                "LEFT JOIN c.menuList m"; // menuList라는 필드를 사용해서 join
        return entityManager.createQuery(jpql).getResultList();
    }

    /* cross join : 모든 조합을 조인하는 것 */
    public List<Object[]> selectByThetaJoin(){
        String jpql = "SELECT c.categoryCode, m.menuName FROM Section06Category c, " +
                "Section06Menu m"; // menuList라는 필드를 사용해서 join
        return entityManager.createQuery(jpql).getResultList();
    }
}
