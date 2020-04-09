package com.lin.landao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.landao.entities.OrderDetail;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

    //新增
    int create(OrderDetail orderDetail);

    //根据id查询
    OrderDetail getOrderDetailById(Integer id);

    //查询所有
    List<OrderDetail> queryOrderDetailAll();

    //根据id删除
    void deleteOrderDetailById(Integer id);
    List<OrderDetail> queryOrderDetailAllById(Integer id);

    //根据id修改
//    void updateOrderDetailById(OrderDetail orderDetail);

}
