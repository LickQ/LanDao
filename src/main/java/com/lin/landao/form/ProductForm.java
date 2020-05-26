package com.lin.landao.form;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductForm {


    private Integer productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private Integer productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private String categoryType;
}
