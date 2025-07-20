package com.dbwls.springmybatis.section01.factorybean;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final SqlSessionTemplate sqlSession;

    /* 생성자 주입 */
    public MenuService(SqlSessionTemplate sqlSession){
        this.sqlSession = sqlSession;
    }

    public List<MenuDTO> findAllMenuByOrderableStatus(String orderableStatus){
        List<MenuDTO> menus =
                sqlSession.getMapper(MenuMapper.class)
                        .findAllMenuByOrderableStatus(orderableStatus);

        /* 가공하는 과정 */
        if(menus!=null && !menus.isEmpty()) {
            menus.forEach(menu -> {
                if ("Y".equals(menu.getOrderableStatus())) {
                    menu.setMenuName(menu.getMenuName() + " (주문 가능)");
                } else {
                    menu.setMenuName(menu.getMenuName() + " (주문 불가능)");
                }
            });
        }

        return menus;
    }
}
