package com.dbwls.springmybatis.section01.factorybean;

import java.util.List;

public interface MenuMapper {

    List<MenuDTO> findAllMenuByOrderableStatus(String orderableStatus);
}
