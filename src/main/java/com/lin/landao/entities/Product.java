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
@ApiModel(value = "Product对象", description = "")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "product_id", type = IdType.AUTO)
    private Integer productId;

    @TableField("product_name")
    private String productName;

    @TableField("product_price")
    private Integer productPrice;

    @TableField("product_stock")
    private Integer productStock;

    @TableField("product_description")
    private String productDescription;

    @TableField("product_icon")
    private String productIcon;

    @TableField("product_status")
    private Integer productStatus;

    @TableField("category_type")
    private String categoryType;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("inn_id")
    private Integer innId;


}
