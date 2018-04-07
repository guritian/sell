package com.imooc.enums;

import lombok.Getter;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/7
 * Time:21:29
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消")
    ;

    private  Integer code;
    private  String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
