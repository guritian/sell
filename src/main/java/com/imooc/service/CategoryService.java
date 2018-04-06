package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目服务
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/5
 * Time:21:30
 */
public interface CategoryService {
    //给后台管理使用的
    ProductCategory findOne(Integer categoryId);



    List<ProductCategory> findAll();
    //卖家端使用的
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);   //通过买家想要搜索的 商品类目 来查找相关的实体列表
    ProductCategory save(ProductCategory productCategory);      //新增或更新类目信息
}
