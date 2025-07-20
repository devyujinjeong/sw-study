package com.dbwls.transaction.mapper;

import com.dbwls.transaction.domain.Order;
import com.dbwls.transaction.domain.OrderMenu;
import org.apache.ibatis.annotations.Mapper;

/* Bean 스캔 될 수 있도록 함*/
@Mapper
public interface OrderMapper {
    void insertOrder(Order order);

    void insertOrderMenu(OrderMenu orderMenu);
}
