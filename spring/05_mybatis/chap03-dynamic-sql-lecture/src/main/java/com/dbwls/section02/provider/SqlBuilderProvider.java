package com.dbwls.section02.provider;

import com.dbwls.common.MenuDTO;
import org.apache.ibatis.jdbc.SQL;

public class SqlBuilderProvider {
    public String insertMenu(MenuDTO menuDTO){
        return new SQL()
                .INSERT_INTO("tbl_menu")
                .VALUES("menu_name", "#{menuName}")
                .VALUES("menu_price", "#{menuPrice}")
                .VALUES("category_code", "#{categoryCode}")
                .VALUES("orderable_status", "#{orderableStatus}")
                .toString();
    }

    public String updateMenu(MenuDTO menu) {
        SQL sql = new SQL();

        sql.UPDATE("tbl_menu");

        if(menu.getMenuName() != null && !"".equals(menu.getMenuName())) {
            sql.SET("menu_name = #{ menuName }");
        }
        if(menu.getMenuPrice() > 0) {
            sql.SET("menu_price = #{ menuPrice }");
        }
        if(menu.getCategoryCode() > 0) {
            sql.SET("category_code = #{ categoryCode }");
        }
        if(menu.getOrderableStatus() != null && !"".equals(menu.getOrderableStatus())) {
            sql.SET("orderable_status = #{ orderableStatus }");
        }

        sql.WHERE("menu_code = #{ menuCode }");

        return sql.toString();
    }

    public String deleteMenu() {
        return new SQL()
                .DELETE_FROM("tbl_menu")
                .WHERE("menu_code = #{menuCode}")
                .toString();
    }
}
