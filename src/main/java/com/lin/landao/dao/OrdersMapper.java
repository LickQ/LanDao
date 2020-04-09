package com.lin.landao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.landao.dto.OrderDTO;
import com.lin.landao.entities.OrderPage;
import com.lin.landao.entities.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
public interface OrdersMapper extends BaseMapper<Orders> {
    //新增
    int create(Orders orders);

    //根据id查询
    Orders getOrdersById(Integer id);

    //查询所有
    List<Orders> queryOrdersAll();

    //查询user所以信息
    List<Orders> queryOrdersAllByUserId(Integer id);

    //根据id删除
    void deleteOrdersById(Integer id);

    //根据id修改
    void updateOrdersById(Orders orders);

    //查询订单和其详细数据
     List<Orders>  queryOdersAndOrderDtail();


    List<Orders> findAll(OrderPage orderPage);

    int countAll(Integer innId);



}
