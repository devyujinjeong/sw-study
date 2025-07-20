package com.dbwls.section02.update;

import java.sql.Connection;

import static com.dbwls.common.JDBCTemplate.*;

public class MenuService {
    public void modifyMenu(Menu modifyMenu) {
        Connection con = getConnection();
        MenuRepository menuRepository = new MenuRepository();
        int result = menuRepository.updateMenu(con, modifyMenu);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }
}