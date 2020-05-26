package com.lin.landao.service.impl;

import com.lin.landao.converter.Order2OrderDTOConverter;
import com.lin.landao.dao.OrdersMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.landao.dao.UserMapper;
import com.lin.landao.dto.CartDTO;
import com.lin.landao.dto.OrderDTO;
import com.lin.landao.entities.*;
import com.lin.landao.enums.OrderStatusEnum;
import com.lin.landao.enums.PayStatusEnum;
import com.lin.landao.enums.ResultEnum;
import com.lin.landao.exception.SellException;
import com.lin.landao.service.OrderDetailService;
import com.lin.landao.service.OrdersService;
import com.lin.landao.service.ProductService;
import com.lin.landao.service.UserService;
import com.lin.landao.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
@Slf4j
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private ProductService productService;
    @Resource
    private OrderDetailService orderDetailService;
    @Resource
    private UserService userService;


    @Transactional
    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {

        Orders orders = new Orders();

        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("【取消订单】订单状态不正确, orderId={}, orderStatus={}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        BeanUtils.copyProperties(orderDTO, orders);
        ordersMapper.updateOrdersById(orders);
        //返回库存
//        判断订单中是否有商品
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【取消订单】订单中无商品详情, orderDTO={}", orderDTO);
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();

        for (OrderDetail orderDetail : orderDetailList) {
            Integer productQuantity = orderDetail.getProductQuantity();
            Integer productId = orderDetail.getProductId();
            CartDTO cartDTO = new CartDTO(productId, productQuantity);
            productService.increaseStock(cartDTO);
        }
        //如果已支付, 需要退款
        if (orderDTO.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())) {
            //Todo
//            payService.refund(orderDTO);
        }

        return orderDTO;
    }

    @Override
    public List<OrderDTO> findList(Integer userId) {

        List<Orders> orders = ordersMapper.queryOrdersAllByUserId(userId);
        List<OrderDTO> orderDTOList = Order2OrderDTOConverter.convert(orders);
        for (OrderDTO orderDTO : orderDTOList) {
            User user = userService.getUserById(userId);
            orderDTO.setUserName(user.getUserName());
            orderDTO.setUserTelephone(Integer.valueOf(user.getUserTelephone()));

        }
        return orderDTOList;

    }







    @Transactional
    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("【完结订单】订单状态不正确, orderId={}, orderStatus={}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        Orders orders = new Orders();
        BeanUtils.copyProperties(orderDTO, orders);
        ordersMapper.updateOrdersById(orders);

        return orderDTO;
    }

    @Override
    public OrderDTO paid(OrderDTO  orderDTO) {
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.error("【订单支付完成】订单状态不正确, orderId={}, orderStatus={}", orderDTO.getOrderId(), orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //判断支付状态
        if (!orderDTO.getPayStatus().equals(PayStatusEnum.WAIT.getCode())) {
            log.error("【订单支付完成】订单支付状态不正确, orderDTO={}", orderDTO);
            throw new SellException(ResultEnum.ORDER_PAY_STATUS_ERROR);
        }

        //修改支付状态
        orderDTO.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        Orders orders = new Orders();
        BeanUtils.copyProperties(orderDTO, orders);
        ordersMapper.updateOrdersById(orders);

        return orderDTO;
    }

    //新增
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) throws NoSuchAlgorithmException {
        //定义总价
        int orderAmount = 0;
        int orderId = KeyUtil.genUniqueKey();
        //设置默认属性
        orderDTO.setCreateTime(new Date());
        orderDTO.setPayStatus(0);
        orderDTO.setOrderStatus(0);

        String telephone = userService.getUserById(orderDTO.getUserId()).getUserTelephone();
        orderDTO.setUserTelephone(Integer.valueOf(telephone));

        List<CartDTO> cartDTOList = new ArrayList<>();
        //1. 查询商品（数量, 价格）
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            Product productById = productService.getProductById(orderDetail.getProductId());
            if (productById == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2. 计算订单总价
            orderAmount = productById.getProductPrice() * orderDetail.getProductQuantity() + orderAmount;
            //订单详情入库
            BeanUtils.copyProperties(productById, orderDetail);
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetailService.create(orderDetail);
            //4. 扣库存
//            CartDTO cartDTO=new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity());
//            cartDTOList.add(cartDTO);
            CartDTO cartDTO = new CartDTO(orderDetail.getProductId(), orderDetail.getProductQuantity());
            productService.decreaseStock(cartDTO);
        }
        //3. 写入订单数据库（orders和orderDetail）
        Orders order = new Orders();
        orderDTO.setOrderAmount(orderAmount);
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, order);
        order.setInnId(orderDTO.getInnId());
        order.setOrderStatus(OrderStatusEnum.NEW.getCode());
        order.setPayStatus(PayStatusEnum.WAIT.getCode());
        ordersMapper.create(order);
        return orderDTO;
    }

    ;

    @Override
    public OrderDTO findOne(Integer orderId) {
        Orders order = ordersMapper.getOrdersById(orderId);
        if (order == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetailList = orderDetailService.queryOrderDetailAllById(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
        OrderDTO orderDTO = new OrderDTO();
        Integer userId = order.getUserId();
        User user = userService.getUserById(userId);
        orderDTO.setUserName(user.getUserName());
        orderDTO.setUserTelephone(Integer.valueOf(user.getUserTelephone()));
        BeanUtils.copyProperties(order, orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    //根据id查询
    public Orders getOrdersById(Integer id) {
        return ordersMapper.getOrdersById(id);
    }

    ;

    //查询所有
    public List<Orders> queryOrdersAll() {
        return ordersMapper.queryOrdersAll();
    }

    ;

    //根据id删除
    public void deleteOrdersById(Integer id) {
        ordersMapper.deleteOrdersById(id);
    }

    ;

    //根据id修改
    public void updateOrdersById(Orders orders) {
        ordersMapper.updateOrdersById(orders);
    }

    ;

    @Override
    public List<Orders> queryOdersAndOrderDtail(Orders orders) {
        return ordersMapper.queryOdersAndOrderDtail();
    }



    @Override
    public Page<OrderDTO> findList(Pageable pageable,Integer innId) {

        OrderPage orderPage = new OrderPage(pageable.getOffset(),pageable.getPageSize(),innId);


        List<Orders> items = ordersMapper.findAll(orderPage);



        int totol = ordersMapper.countAll(innId);
        List<OrderDTO> orderDTOList = Order2OrderDTOConverter.convert(items);
        for (OrderDTO orderDTO:orderDTOList){
            Integer userId = orderDTO.getUserId();
            User user = userService.getUserById(userId);
            String userName = user.getUserName();
            String  userTelephone = user.getUserTelephone();
            orderDTO.setUserName(userName);
            orderDTO.setUserTelephone(Integer.valueOf(userTelephone));
        }


        Page result = new PageImpl(orderDTOList,pageable,totol);

        return result;
    }
}
