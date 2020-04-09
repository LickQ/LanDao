package com.lin.landao.dao;

import com.lin.landao.entities.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailMapperTest {

    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Test
    public void create() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setCreateTime(new Date());
        orderDetail.setOrderId(1);
        orderDetail.setProductIcon("asd");
        orderDetail.setProductId(1);
        orderDetail.setProductName("白菜");
        orderDetail.setProductPrice(10);
        orderDetail.setProductQuantity(10);
        orderDetailMapper.create(orderDetail);
    }

    @Test
    public void getOrderDetailById() {
        OrderDetail orderDetailById = orderDetailMapper.getOrderDetailById(1);
        Assert.assertNotNull(orderDetailById);
    }

    @Test
    public void queryOrderDetailAll() {
    }

    @Test
    public void deleteOrderDetailById() {
    }
}