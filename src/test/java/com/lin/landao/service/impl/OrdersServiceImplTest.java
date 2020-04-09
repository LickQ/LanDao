package com.lin.landao.service.impl;

import com.lin.landao.dto.OrderDTO;
import com.lin.landao.entities.OrderDetail;
import com.lin.landao.entities.Orders;
import com.lin.landao.enums.OrderStatusEnum;
import com.lin.landao.enums.PayStatusEnum;
import com.lin.landao.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrdersServiceImplTest {

    @Resource
    private OrdersService ordersService;
    @Test
    public void create() throws NoSuchAlgorithmException {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(1);
        orderDTO.setUserName("lin");
        orderDTO.setUserTelephone(234);
        orderDTO.setCreateTime(new Date());
        orderDTO.setOrderStatus(0);
        orderDTO.setPayStatus(0);
        List<OrderDetail> orderDetailsList=new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductQuantity(2);
        o1.setProductId(1);
        orderDetailsList.add(o1);
        OrderDetail o2 = new OrderDetail();
        o2.setProductQuantity(10);
        o2.setProductId(2);
        orderDetailsList.add(o2);
        orderDTO.setOrderDetailList(orderDetailsList);
        ordersService.create(orderDTO);

    }

    @Test
    public void getOrdersById() {
    }

    @Test
    public void queryOrdersAll() {
    }

    @Test
    public void deleteOrdersById() {
    }

    @Test
    public void updateOrdersById() {
    }

    @Test
    public void queryOdersAndOrderDtail() {
    }

    @Test
    public void findOne() {
        OrderDTO one = ordersService.findOne(1);
        log.info("返回结果为========",one);
        System.out.println(one.getOrderId()+"----"+one.getUserName());
        Assert.assertNotNull(one);

    }

    @Test
    public void findList() {
        String a="1";
        Integer b=Integer.valueOf(a);
        List<OrderDTO> list = ordersService.findList(b);
        Assert.assertNotNull(list);
    }

    @Test
    public void cancel() {
        OrderDTO one = ordersService.findOne(744);
        OrderDTO cancel = ordersService.cancel(one);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),one.getOrderStatus());

    }

    @Test
    public void finish() {
        OrderDTO one = ordersService.findOne(1);
        OrderDTO cancel = ordersService.finish(one);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),one.getOrderStatus());

    }

    @Test
    public void paid() {
        OrderDTO one = ordersService.findOne(1);
        OrderDTO cancel = ordersService.paid(one);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),one.getOrderStatus());
    }

    @Test
    public void findList1() {
        PageRequest request = PageRequest.of(1-1, 4);
        Page<OrderDTO> list = ordersService.findList(request,1);
        Assert.assertNotNull(list);
    }
}