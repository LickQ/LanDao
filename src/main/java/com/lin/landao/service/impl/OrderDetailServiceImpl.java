package com.lin.landao.service.impl;

import com.lin.landao.dao.OrderDetailMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.landao.entities.OrderDetail;
import com.lin.landao.service.OrderDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
    @Resource
    private OrderDetailMapper orderDetailMapper;

    //新增
    public int create(OrderDetail orderDetail){
        return orderDetailMapper.create(orderDetail);
    };

    //根据id查询
    public OrderDetail getOrderDetailById(Integer id){
        return orderDetailMapper.getOrderDetailById(id);
    };

    @Override
    public List<OrderDetail> queryOrderDetailAllById(Integer id) {
        return  orderDetailMapper.queryOrderDetailAllById(id);
    }

    //查询所有
    public List<OrderDetail> queryOrderDetailAll(){
       return orderDetailMapper.queryOrderDetailAll();
    };

    //根据id删除
    public void deleteOrderDetailById(Integer id){
        orderDetailMapper.deleteOrderDetailById(id);
    };
}
