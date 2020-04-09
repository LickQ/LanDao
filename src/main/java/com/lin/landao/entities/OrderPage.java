package com.lin.landao.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPage {

    private  Long offset;
    private  Integer pageSize;
    private Integer innId;

}
