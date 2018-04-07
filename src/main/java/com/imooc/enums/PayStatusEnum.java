package com.imooc.enums;

import lombok.Getter;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/7
 * Time:21:36
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"未支付"),
    SUCCESS(1,"支付成功")
    ;

    private  Integer code;
    private  String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
