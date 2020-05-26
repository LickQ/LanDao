package com.lin.landao.dto;

import lombok.Data;

/**
 * 购物车
 */
@Data
public class CartDTO {

    /** 商品Id. */
    private Integer productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(Integer productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
