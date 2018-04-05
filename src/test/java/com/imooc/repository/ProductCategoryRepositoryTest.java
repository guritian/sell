package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.hibernate.boot.jaxb.SourceType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/4
 * Time:21:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
     private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }


    @Test
    @Transactional      //在测试中起到完全回滚的作用   加上这个注解之后 ，测试完成之后 所有测试数据全部回滚  不会影响到数据库
    public void saveTest(){

        ProductCategory productCategory =new ProductCategory("男生最爱",2);
        ProductCategory result= repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result= repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}