package com.lin.landao.converter;

import com.lin.landao.dto.OrderDTO;
import com.lin.landao.entities.Orders;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;


public class Order2OrderDTOConverter {
    private Order2OrderDTOConverter(){

    }
    private static OrderDTO convert(Orders orders) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orders, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<Orders> orderList) {
        return orderList.stream().map(Order2OrderDTOConverter::convert).collect(Collectors.toList());
    }
}
