package com.lin.landao.entities;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Orders对象", description = "")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;



    private List<OrderDetail> orderDetails;

    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    @TableField("user_id")
    private Integer userId;

    @TableField("order_amount")
    private Integer orderAmount;

    @TableField("order_status")
    private Integer orderStatus;

    @TableField("pay_status")
    private Integer payStatus;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    private Integer innId;



}
