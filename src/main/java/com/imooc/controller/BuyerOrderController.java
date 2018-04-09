package com.imooc.controller;

import com.imooc.VO.ResultVO;
import com.imooc.converter.OrderForm2OrderDTOConverter;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.OrderForm;
import com.imooc.service.OrderService;
import com.imooc.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/9
 * Time:22:08
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;
    //创建订单
    @PostMapping(value = "/create")
    @Transactional
    public ResultVO<Map<String ,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数填写不正确，orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        //需要将  我们得到的OrderForm对象转换为  我们需要的OrderDTO对象  所以我们还需要写一个转换类
        OrderDTO orderDTO =new OrderDTO();
        orderDTO=  OrderForm2OrderDTOConverter.convert(orderForm);
        //为了判断购物车是否为空 还是要再做一次判断
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList()))
        {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

      OrderDTO createResult =  orderService.create(orderDTO);
        Map<String,String> map =   new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVOUtil.success(map);

    }
    //订单列表

    //订单详情

    //取消订单

}
