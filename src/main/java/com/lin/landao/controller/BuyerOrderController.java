package com.lin.landao.controller;

import com.lin.landao.converter.OrderForm2OrderDTOConverter;
import com.lin.landao.dto.OrderDTO;
import com.lin.landao.enums.ResultEnum;
import com.lin.landao.exception.SellException;
import com.lin.landao.form.OrderForm;
import com.lin.landao.service.OrdersService;
import com.lin.landao.service.UserService;
import com.lin.landao.utils.ResultVOUtil;
import com.lin.landao.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrdersService orderService;
    @Autowired
    private UserService userService;


    //创建订单
    @PostMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult) throws NoSuchAlgorithmException {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, Integer> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO list(@RequestParam("userId") Integer userId) {
        if (StringUtils.isEmpty(userId)) {
            log.error("【查询订单列表】userId");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        List<OrderDTO> orderDTOlist = orderService.findList(userId);
        return ResultVOUtil.success(orderDTOlist);
    }

    //
//
//    //订单详情
    @GetMapping("/detail")
    public ResultVO detail(@RequestParam("orderId") Integer orderId,@RequestParam("userId") Integer userId) {

        OrderDTO orderDTO = orderService.findOne(orderId);
        //todo 不安全
        if (userId!=orderDTO.getUserId()){
            log.error("【查询订单】订单的openid不一致. openid={}, orderDTO={}", userId, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return ResultVOUtil.success(orderDTO);
    }
//
//    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel( @RequestParam("orderId") Integer orderId,@RequestParam("userId") Integer userId) {
        OrderDTO orderDTO= orderService.findOne(orderId);
        //todo 不安全
        if (userId!=orderDTO.getUserId()){
            log.error("【查询订单】订单的openid不一致. openid={}, orderDTO={}", userId, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        orderService.cancel(orderDTO);
        return ResultVOUtil.success();
    }
}
