package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/10
 * Time:10:52
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);
    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
