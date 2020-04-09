package com.lin.landao.dao;

import com.lin.landao.entities.OrderPage;
import com.lin.landao.entities.Orders;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersMapperTest {

    @Resource
    private OrdersMapper ordersMapper;
    @Test
    public void create() {
        Orders orders = new Orders();
        orders.setCreateTime(new Date());
        orders.setOrderAmount(10);
        orders.setOrderStatus(0);
        orders.setPayStatus(0);
        orders.setUserId(1);
        ordersMapper.create(orders);

    }

    @Test
    public void getOrdersById() {
    }

    @Test
    public void queryOrdersAll() {
    }

    @Test
    public void queryOrdersAllByUserId() {
        List<Orders> orders = ordersMapper.queryOrdersAllByUserId(1);
        Assert.assertNotNull(orders);
    }

    @Test
    public void deleteOrdersById() {
    }

    @Test
    public void updateOrdersById() {
    }

    @Test
    public void queryOdersAndOrderDtail() {
        List<Orders> orders = ordersMapper.queryOdersAndOrderDtail();
        Assert.assertNotNull(orders);
    }


//    @Test
//    public void findAll1() {
////
////        OrderPage orderPage = new OrderPage(0L,3);
////        List<Orders> all = ordersMapper.findAll(orderPage);
////        Assert.assertNotNull(all);
//
//    }

    @Test
    public void countAll() {
//        int i = ordersMapper.countAll();
//        System.out.println(i);
    }
}