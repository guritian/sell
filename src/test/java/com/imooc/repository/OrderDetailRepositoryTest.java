package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/8
 * Time:10:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;
    @Test
    public void  saveTest() {
        OrderDetail orderDetail =new OrderDetail();
        orderDetail.setOrderId("123544345");
        orderDetail.setDetailId("12345");
        orderDetail.setProductId("13123123");
        orderDetail.setProductName("皮皮虾");
        orderDetail.setProductPrice(new BigDecimal(12));
        orderDetail.setProductQuantity(12);
        orderDetail.setProductIcon("asdasd.jpg");
        OrderDetail result= repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId()throws Exception{
        List<OrderDetail> orderDetailList =repository.findByOrderId("123544345");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}