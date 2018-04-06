package com.imooc.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/6
 * Time:11:16
 */
@Getter
public enum ProductStatusEnum {
    UP (0,"上架"),
    DOWN (1,"下架")
    ;
    private Integer code;
    private String message;
    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message =message;
    }

}
