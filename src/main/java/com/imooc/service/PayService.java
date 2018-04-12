package com.imooc.service;

import com.imooc.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;

/**
 * 支付
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/11
 * Time:15:02
 */
public interface PayService {
    //创建支付订单
    PayResponse create(OrderDTO orderDTO);

}
