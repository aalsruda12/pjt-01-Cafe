package com.miniproject.cafe.Impl;

import com.miniproject.cafe.Mapper.OrderDetailMapper;
import com.miniproject.cafe.Service.OrderDetailService;
import com.miniproject.cafe.VO.OrderDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OrderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {


    @Autowired
    private OrderDetailMapper orderDetailMapper;


    @Override
    public int orderDetail(OrderDetailVO orderDetailVO) {
        return orderDetailMapper.orderDetail(orderDetailVO);
    }
}
