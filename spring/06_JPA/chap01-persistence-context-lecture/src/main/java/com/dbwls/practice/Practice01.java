package com.dbwls.practice;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Practice01 {
    public static void main(String[] args) {
        // EntityManagerFactory 생성하기
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");

        // EntityManagerFactory를 통해 EntityManager 만들기
        EntityManager em = emf.createEntityManager();



        emf.close();
        em.close();
    }
}
