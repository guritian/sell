package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/4
 * Time:21:18
 */

//继承 JpaRepository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

}
