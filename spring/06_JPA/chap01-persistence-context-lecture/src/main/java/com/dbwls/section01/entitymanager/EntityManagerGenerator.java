package com.dbwls.section01.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EntityManagerGenerator {

    public static EntityManager getInstance() {
        // factory를 가져와서
        EntityManagerFactory factory
                = EntityManagerFactoryGenerator.getInstance();
        // entityManager 생성하기
        return factory.createEntityManager();
    }

}