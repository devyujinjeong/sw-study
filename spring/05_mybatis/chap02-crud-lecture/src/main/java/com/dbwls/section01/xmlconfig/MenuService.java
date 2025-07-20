package com.dbwls.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.dbwls.section01.xmlconfig.Template.getSqlSession;

public class MenuService {
    private final MenuDAO menuDAO;

    public MenuService() {
        this.menuDAO = new MenuDAO(); // 현재 IoC 컨테이너를 통해 하는 것이 아님!
    }

    public List<MenuDTO> selectAllMenu() {
        // 1. sqlSession 객체 생성하기
        SqlSession sqlSession = getSqlSession();

        // 2. menuDAO의 메소드를 실행하고 값을 리턴하기
        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);

        // 3. sqlsession은 항상 닫아줘야 함
        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        MenuDTO menuDTO = menuDAO.selectMenuByMenuCode(sqlSession,menuCode);

        sqlSession.close();

        return menuDTO;
    }

    public boolean registMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.insertMenu(sqlSession, menu);

        if(result>0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result>0;
    }

    /* 메소드명, id 등 : updateMenu*/
    public boolean modifyMenu(MenuDTO menu) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.updateMenu(sqlSession, menu);

        if(result>0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result>0;
    }

    /* 메소드명, id 등 : deleteMenu*/
    public boolean deleteMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.deleteMenu(sqlSession, menuCode);

        if(result>0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result>0;
    }

}