package com.lin.landao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.landao.dto.OrderDTO;
import com.lin.landao.entities.OrderDetail;
import com.lin.landao.entities.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
public interface OrdersService extends IService<Orders> {
    //新增
    OrderDTO create(OrderDTO orderDTO) throws NoSuchAlgorithmException;

    //根据id查询
    Orders getOrdersById(Integer id);

    //查询所有
    List<Orders> queryOrdersAll();

    //根据id删除
    void deleteOrdersById(Integer id);

    //根据id修改
    void updateOrdersById(Orders orders);
    //查询订单和其详细数据
    List<Orders>  queryOdersAndOrderDtail(Orders orders);
    /** 查询单个订单. */
    OrderDTO findOne(Integer orderId);

    /** 查询订单列表. */
    List<OrderDTO> findList(Integer userId);
    /** 取消订单. */
    OrderDTO cancel(OrderDTO orderDTO);

    /** 完结订单. */
    OrderDTO finish(OrderDTO orderDTO);

    /** 支付订单. */
    OrderDTO paid(OrderDTO orderDTO);

    /** 查询订单列表. */
    Page<OrderDTO> findList(Pageable pageable,Integer innId);



}
