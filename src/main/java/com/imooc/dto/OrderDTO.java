package com.imooc.dto;

import com.imooc.dataobject.OrderDetail;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/8
 * Time:13:53
 */
@Data
public class OrderDTO {
    private String orderId;   //订单ID
    private String buyerName;   //买家名字
    private String buyerPhone;  //买家电话
    private String buyerAddress;    //买家地址
    private String buyerOpenid;     //买家的Openid
    private BigDecimal orderAmount;     //订单总金额
    private Integer orderStatus;       //订单状态   默认值为0  默认为新下单
    private Integer payStatus;          //支付状态
    private Date createTime;
    private Date updateTime;
    private List<OrderDetail> orderDetailList;
}
