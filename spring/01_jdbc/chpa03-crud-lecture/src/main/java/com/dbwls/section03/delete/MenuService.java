package com.dbwls.section03.delete;

import java.sql.Connection;

import static com.dbwls.common.JDBCTemplate.*;

/* Service 계층 : 비즈니스 로직을 구현하는 계층
 * 기능의 수행 결과에 따라 commit, rollback 처리가 일어남
 * */
public class MenuService {
    public void removeMenu(int menuCode) {
        Connection con = getConnection();
        MenuRepository menuRepository = new MenuRepository();
        int result = menuRepository.deleteMenu(con,menuCode);

        if(result>0){
            commit(con);
        }else{
            rollback(con);
        }

        close(con);
    }
}