package com.dbwls.section01.entitymanager;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryGenerator {
    // Entity는 EntityManager이 관리하고, 이러한 EntityManager를 EntityManagerFactory가 생성해준다.
    // EntityManagerFactory는 하나만 있으면 되므로 static로 설정한다.
    // EntityManagerFactory를 생성할 때는, 이와 관련된 설정 정보가 있느 파일을 읽어오면 된다.
    private static EntityManagerFactory factory
            = Persistence.createEntityManagerFactory("jpatest");

    // 객체 생성 차단을 위한 것 -> 싱글톤 패턴을 구현하는 것이므로
    private EntityManagerFactoryGenerator() {}

    public static EntityManagerFactory getInstance() {
        return factory;
    }
}