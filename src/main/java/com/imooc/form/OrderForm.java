package com.imooc.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/9
 * Time:22:16
 */
@Data
public class OrderForm {
//    创建订单  API
//    name: "张三"
//    phone: "18868822111"
//    address: "慕课网总部"
//    openid: "ew3euwhd7sjw9diwkq" //用户的微信openid
//    items: [{
//        productId: "1423113435324",
//                productQuantity: 2 //购买数量
//    }]

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;
    /**
     * 买家手机号
     */
    @NotEmpty(message = "电话必填")
    private String phone;
    @NotEmpty(message = "送货地址必填")
    private String address;
    @NotEmpty(message = "openid必填")
    private String openid;
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
