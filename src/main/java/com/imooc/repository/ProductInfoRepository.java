package com.imooc.repository;

import com.imooc.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/6
 * Time:10:34
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

        List<ProductInfo> findByProductStatus(Integer productStatus);  //通过  商品状态查询商品信息


}
