package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/8
 * Time:11:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;
    @Test
    public void saveTest(){
        OrderMaster orderMaster =new OrderMaster();
        orderMaster.setBuyerName("渣渣辉");
        orderMaster.setBuyerOpenid("1102");
        orderMaster.setBuyerAddress("香港");
        orderMaster.setBuyerPhone("870288291212");
        orderMaster.setOrderAmount(new BigDecimal(8.8));
        orderMaster.setOrderId("231s");
       OrderMaster result= repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {

        PageRequest request =new PageRequest(0,3);
        Page<OrderMaster> result =repository.findByBuyerOpenid("1102",request);
        //System.out.println(result.getTotalElements());
        Assert.assertNotEquals(0,result.getTotalElements());
    }
}