package com.miniproject.cafe.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailVO {
    private String orderDetailId;
    private String orderId;
    private String menuId;
    private String memberId;
    private int amount;
    private String tumbler;
    private int shot;
    private int vanillaSyrup;
    private int cream;
}
