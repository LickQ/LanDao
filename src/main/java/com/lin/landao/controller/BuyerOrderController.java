package com.lin.landao.controller;

import com.lin.landao.converter.OrderForm2OrderDTOConverter;
import com.lin.landao.dto.OrderDTO;
import com.lin.landao.entities.OrderDetail;
import com.lin.landao.entities.Product;
import com.lin.landao.enums.ResultEnum;
import com.lin.landao.exception.SellException;
import com.lin.landao.form.OrderForm;
import com.lin.landao.service.OrdersService;
import com.lin.landao.service.ProductService;
import com.lin.landao.service.UserService;
import com.lin.landao.utils.ResultVOUtil;
import com.lin.landao.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
//@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrdersService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    //创建订单
    @RequestMapping(value = "/createOrder.action")
    public ModelAndView create(Integer productId, Integer buyNum, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Product product = productService.getProductById(productId);
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(user, orderDTO);
        BeanUtils.copyProperties(product,orderDTO);
        orderDTO.setStartDate(new Date());
        orderDTO.setEndDate(new Date());
        List<OrderDetail> orderDetailsList=new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId(productId);
        o1.setProductQuantity(buyNum);
        o1.setCreateTime(new Date());
        o1.setProductIcon(product.getProductIcon());
        orderDetailsList.add(o1);
        orderDTO.setOrderDetailList(orderDetailsList);
        OrderDTO orderDTO1=new OrderDTO();
        try {
             orderDTO1 = orderService.create(orderDTO);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        ModelAndView mav = new ModelAndView();
        mav.addObject("orderDetail",o1);
        mav.addObject("product",product);
        mav.addObject("orderDTO1",orderDTO1);
        mav.setViewName("cart");
        return mav;
    }

    //支付
    @GetMapping("/paid")
    public ModelAndView paid(Integer orderId) {
        OrderDTO order = orderService.findOne(orderId);
        if (StringUtils.isEmpty(order)) {
            log.error("购物车为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        OrderDTO paid = orderService.paid(order);
        ModelAndView mav = new ModelAndView();
        mav.addObject("innId",order.getInnId());
        mav.setViewName("success");
        return  mav;
    }

    @GetMapping("/finish")
    public ModelAndView finished(@RequestParam("orderId") Integer orderId,
                                 Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (SellException e) {
            log.error("【卖家端完结订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url", "/seller/order/list");
        return new ModelAndView("common/success");
    }






    //
//
//    //订单详情
    @GetMapping("/buyer/order/detail")
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
    @PostMapping("/buyer/order/cancel")
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
