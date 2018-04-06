package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/6
 * Time:10:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest  {
    @Autowired
   private ProductInfoRepository productInfoRepository;
    @Test
    public void save() throws Exception{
        ProductInfo productInfo =new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("小米粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("香甜软糯 营养健康");
        productInfo.setProductIcon("XXXXXXXXXX.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(10);
        ProductInfo result= productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfoList =productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }
}