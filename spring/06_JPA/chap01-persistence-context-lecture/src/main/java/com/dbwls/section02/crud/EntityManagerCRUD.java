package com.dbwls.section02.crud;

import com.dbwls.section01.entitymanager.EntityManagerGenerator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class EntityManagerCRUD {
    private EntityManager entityManager;

    /* 1. 특정 메뉴 코드로 메뉴를 조회하는 기능 */
    public Menu findMenuByMenuCode(int menuCode){
        entityManager = EntityManagerGenerator.getInstance();
        // 어떤 타입의 엔티티를 찾을것이며, 이것의 PK가 무엇인지 전달
        return entityManager.find(Menu.class, menuCode);
    }

    /* 2. 새로운 메뉴를 저장하는 기능 */
    public Long saveAndReturnAllCount(Menu newMenu){
        entityManager = EntityManagerGenerator.getInstance();

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(newMenu);

        entityTransaction.commit();

        return getCount(entityManager);
    }

    private Long getCount(EntityManager entityManager){
        // JPQL
        return entityManager.createQuery("SELECT COUNT(*) FROM Section02Menu", Long.class).getSingleResult();
    }

    /* 3. 메뉴 이름 수정 기능 */
    public Menu modifyMenuName(int menuCode, String menuName){
        entityManager = EntityManagerGenerator.getInstance();
        // entityManger는 수정한다는 기능을 가지고 있지 않음
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        foundMenu.setMenuName(menuName);

        entityTransaction.commit();

        return foundMenu;
    }

    /* 4. 메뉴 이름 삭제 기능 */
    public Long removeAndReturnAllCount(int menuCode){
        entityManager = EntityManagerGenerator.getInstance();

        // 객체를 우선 찾고
        Menu foundMenu = entityManager.find(Menu.class, menuCode);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // 메뉴 코드를 이용해서 삭제
        entityManager.remove(foundMenu);

        entityTransaction.commit();

        return getCount(entityManager);
    }
}
