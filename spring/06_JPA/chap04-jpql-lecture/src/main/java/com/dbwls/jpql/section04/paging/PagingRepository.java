package com.dbwls.jpql.section04.paging;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PagingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /* 우리는 mariadb를 이용하고 있기 때문에, limit을 이용한 구문이 생성된 것을 볼 수 있다.*/
    public List<Menu> usingPagingAPI(int offset, int limit){
        String jpql = "SELECT m FROM Section04Menu m ORDER BY m.menuCode DESC";

        // DB에서 sql문 배우면서 봤던 limit의 역할임
        List<Menu> menuList = entityManager.createQuery(jpql, Menu.class)
                .setFirstResult(offset) // 조회를 시작할 위치 (0부터) -> offset이 10이면 0~9 넘기고 10부터 조회
                .setMaxResults(limit) // 조회할 데이터 개수
                .getResultList();

        return menuList;
    }
}
