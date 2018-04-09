package com.imooc.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.dataobject.OrderDetail;
import com.imooc.dataobject.OrderMaster;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/9
 * Time:22:31
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        Gson gson=new Gson();
        OrderDTO orderDTO =new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList=new ArrayList<>();
    try {
       orderDetailList= gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {}.getType());
    }
    catch (Exception e){
        log.error("【对象转换】错误，string={}",orderForm.getItems());
        throw new SellException(ResultEnum.PARAM_ERROR);
    }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderForm> orderFormList){
        return orderFormList.stream().map(e->convert(e)).collect(Collectors.toList());
    }
}
