package com.imooc.dto;

import lombok.Data;

/**
 * 购物车
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/8
 * Time:21:47
 */
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
    public CartDTO(){

    }
}
