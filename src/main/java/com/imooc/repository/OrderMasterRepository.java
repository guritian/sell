package com.imooc.repository;

import com.imooc.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/7
 * Time:22:04
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    //按照买家的OpenID  来查询他的订单   并且会做分页
    Page<OrderMaster> findByBuyerOpendi(String buyerOpenid, Pageable pageable);


}
