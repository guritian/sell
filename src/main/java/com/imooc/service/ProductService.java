package com.imooc.service;

import com.imooc.dataobject.ProductInfo;
import com.imooc.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/6
 * Time:11:01
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * 查询所有上架商品信息
     * @return
     */
    List<ProductInfo> findOnsaleAll();

    Page<ProductInfo> findAll(Pageable pageable);  //需要支持分页

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
