package com.lin.landao.converter;

import com.google.common.reflect.TypeToken;
import com.lin.landao.dto.OrderDTO;
import com.lin.landao.entities.OrderDetail;
import com.lin.landao.enums.ResultEnum;
import com.lin.landao.exception.SellException;
import com.lin.landao.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import com.google.gson.Gson;
import java.util.List;

@Slf4j
public class OrderForm2OrderDTOConverter {
    private OrderForm2OrderDTOConverter(){

    }
    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserName(orderForm.getName());

        orderDTO.setUserTelephone(orderForm.getPhone());
        orderDTO.setUserId(orderForm.getUserId());

        List<OrderDetail> orderDetailList;
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {}.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
