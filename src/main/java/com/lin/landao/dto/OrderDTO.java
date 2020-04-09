package com.lin.landao.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lin.landao.entities.OrderDetail;
import com.lin.landao.enums.OrderStatusEnum;
import com.lin.landao.enums.PayStatusEnum;
import com.lin.landao.utils.EnumUtil;
import com.lin.landao.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {

    /** 订单id. */
    private Integer orderId;

    private Integer userId;

    private Integer innId;

    @TableField("user_name")
    private String userName;

    @TableField("user_telephone")
    private Integer userTelephone;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private Integer orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    @TableField("create_time")
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @TableField("update_time")
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }

}
