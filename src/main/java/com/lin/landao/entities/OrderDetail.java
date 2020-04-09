package com.lin.landao.entities;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

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
@ApiModel(value = "OrderDetail对象", description = "")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "detail_id", type = IdType.AUTO)
    private Integer detailId;

    @TableField("order_id")
    private Integer orderId;

    @TableField("product_id")
    private Integer productId;

    @TableField("product_name")
    private String productName;

    @TableField("product_price")
    private Integer productPrice;

    @TableField("product_quantity")
    private Integer productQuantity;

    @TableField("product_icon")
    private String productIcon;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;


}
