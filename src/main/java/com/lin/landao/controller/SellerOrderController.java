package com.lin.landao.controller;

import com.lin.landao.dto.OrderDTO;
import com.lin.landao.enums.ResultEnum;
import com.lin.landao.exception.SellException;
import com.lin.landao.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 卖家端订单
 */

@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrdersService orderService;
//
//    /**
//     * 订单列表
//     * @param page 第几页, 从1页开始
//     * @param size 一页有多少条数据
//     * @return
//     */

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map,HttpServletRequest requset) {
        PageRequest request = PageRequest.of(page - 1, size);
        //获取innId
        HttpSession session=requset.getSession();
        Integer innId = (Integer) session.getAttribute("innId");
        //todo
//        Integer innId=1;
        Page<OrderDTO> orderDTOPage = orderService.findList(request,innId);
        List<String> datelist=new ArrayList();
        for (OrderDTO orderDTO:orderDTOPage)
        {
            String createTime = orderDTO.getCreateTime().toString();
            datelist.add(createTime);

        }
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
//        orderDTOPage.getTotalPages()
        return new ModelAndView("/order/list", map);
    }



//    /**
//     * 取消订单
//     * @param orderId
//     * @return
//     */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") Integer orderId,
                               Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (SellException e) {
            log.error("【卖家端取消订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url", "/seller/order/list");
        return new ModelAndView("common/success");
    }
//
//    /**
//     * 订单详情
//     * @param orderId
//     * @param map
//     * @return
//     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {

        //将带有逗号的字符串用正则表达式转换为integer类型
//        String regEx = "[^0-9]";
//        Pattern p = Pattern.compile(regEx);
//        Matcher m = p.matcher(orderId);
//        Integer orderId1=Integer.valueOf(m.toString());
//        将带有位数,的字符串转换为integer类型
        String orderId1="";
        for (int i=0;i<orderId.length();i++)
        {
            if (orderId.charAt(i)>=48 &&orderId.charAt(i)<=57 ){
            orderId1+=orderId.charAt(i);
            }
        }


        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findOne(Integer.valueOf(orderId1));
        }catch (SellException e) {
            log.error("【卖家端查询订单详情】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail", map);
    }
//
//    /**
//     * 完结订单
//     * @param orderId
//     * @param map
//     * @return
//     */
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
}
