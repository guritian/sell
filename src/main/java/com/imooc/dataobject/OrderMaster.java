package com.imooc.dataobject;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表实体
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/7
 * Time:20:01
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private String orderId;   //订单ID
    private String buyerName;   //买家名字
    private String buyerPhone;  //买家电话
    private String buyerAddress;    //买家地址
    private String buyerOpenid;     //买家的Openid
    private BigDecimal orderAmount;     //订单总金额
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();       //订单状态   默认值为0  默认为新下单
    private Integer payStatus= PayStatusEnum.WAIT.getCode();          //支付状态
    private Date createTime;
    private Date updateTime;

}
