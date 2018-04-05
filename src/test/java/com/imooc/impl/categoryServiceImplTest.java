package com.imooc.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.imooc.dataobject.ProductCategory;
import com.imooc.service.categoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/5
 * Time:21:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class categoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> list =categoryService.findAll();
        Assert.assertNotEquals(0,list.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> list=categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3,4));
        Assert.assertNotEquals(0,list.size());

    }

    @Test
    public void save() throws Exception  {
        ProductCategory productCategory = new ProductCategory("男士专享",4);
       ProductCategory result= categoryService.save(productCategory);
       Assert.assertNotNull(result);


    }
}