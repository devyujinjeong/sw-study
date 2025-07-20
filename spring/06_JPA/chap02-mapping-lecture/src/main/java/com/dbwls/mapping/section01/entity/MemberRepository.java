package com.dbwls.mapping.section01.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // 1. 멤버 저장하기
    public void save(Member member) {
        entityManager.persist(member);
    }

    // 2. memberId로 이름 찾기 with jpql
    public String finNameById(String memberId) {
        // JPQL 활용 (테이블명 -> 엔티티명, 컬럼명 -> 필드명)
        // 대상이 테이블이 아니라 엔티티 이므로, 컬럼명과 필드명이 들어가야 한다.
        String jpql
                = "SELECT m.memberName FROM entityMember m "
                + "WHERE m.memberId = '" + memberId + "'";
        return entityManager.createQuery(jpql, String.class).getSingleResult();
    }
}