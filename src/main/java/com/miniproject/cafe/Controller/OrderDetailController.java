package com.miniproject.cafe.Controller;

import com.miniproject.cafe.Service.OrderDetailService;
import com.miniproject.cafe.VO.OrderDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class OrderDetailController {

    @Autowired
    @Qualifier("OrderDetailService")
    private OrderDetailService orderDetailService;

    @GetMapping("/order_detail")
    public String orderDetail() {
        return "order_detail";
    }

    @PostMapping("/orderComplete")
    public String orderDetail(OrderDetailVO orderDetailVO) {
        orderDetailService.orderDetail(orderDetailVO);
        System.out.println(orderDetailVO.toString());
        return "redirect:/home/order_detail";
    }

}
