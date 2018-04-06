package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/6
 * Time:10:10
 */
@Entity
@DynamicUpdate
@Data
public class ProductInfo {
    @Id
    private String productId;

    private String productName;         //商品名字

    private BigDecimal productPrice;     //单价

    private Integer productStock;      //库存

    private String productDescription;    //描述

    private String productIcon;          //小图  链接地址

    private Integer productStatus;        //商品状态 0正常 1下架

    private Integer categoryType;          //类目编号   商品和类目之间的纽带

    public ProductInfo(){

    }

}
