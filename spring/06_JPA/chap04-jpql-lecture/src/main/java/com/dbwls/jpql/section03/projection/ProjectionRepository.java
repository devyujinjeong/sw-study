package com.dbwls.jpql.section03.projection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /* 1. 영속성 컨텍스트에서 관리된다.*/
    /* Menu가 엔티티 객체로 되어 있기 때문에 영속성 컨텍스트에서 관리된다. */
    public List<Menu> singleEntityProjection(){
        String jpql = "SELECT m FROM Section03Menu m";
        return entityManager.createQuery(jpql,Menu.class).getResultList();
    }

    /* 2. 임베디드 타입을 리스트로 반환하고 있다.
    * 그러데 MenuInfo는 현재 엔티티로 등록되어 있지 않기 때문에 영속성 컨텍스트에서 관리되지 않는다. */
    public List<MenuInfo> embeddedTypeProjection(){
        String jpql = "SELECT m.menuInfo FROM EmbeddedMenu m";
        return entityManager.createQuery(jpql, MenuInfo.class).getResultList();
    }

    /* 3. 필요한 컬럼만 프로젝션 : 스칼라 프로젝션 */
    public List<Object[]> scalarTypeProjection(){
        // 두 개의 타입을 묶을 타입이 없기 때문에 Object 배열 타입으로 반환
        String jpql = "SELECT c.categoryCode, c.categoryName FROM Section03Category c";
        return entityManager.createQuery(jpql).getResultList();
    }

    /* 4. new 명령어를 활용한 프로젝션 */
    public List<CategoryInfo> newCommandProjection(){
        String jpql = "SELECT new com.dbwls.jpql.section03.projection.CategoryInfo(c.categoryCode, c.categoryName) FROM Section03Category c";
        return entityManager.createQuery(jpql, CategoryInfo.class).getResultList();
    }
}
