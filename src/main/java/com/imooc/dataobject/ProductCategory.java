package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/4
 * Time:21:06
 */

//通过@Entity我们可以将这个数据类 映射到数据库
@Entity
@DynamicUpdate//这个注解  可以在Date类型数据发生修改时 更新
@Data
public class ProductCategory {
    /**类目id.*/
    @Id           //id用@Id设置为主键   用@GeneratedValue将他设置为自增
    @GeneratedValue
    private Integer categoryId;
    /**类目名称.*/
    private String categoryName;
    /**类目编号.*/
    private Integer categoryType;

    private Date updateTime;
    private Date createTime;

}
