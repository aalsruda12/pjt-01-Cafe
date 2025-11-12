package com.miniproject.cafe.Mapper;

import com.miniproject.cafe.VO.OrderDetailVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailMapper {
    int orderDetail(OrderDetailVO orderDetailVO);
}
