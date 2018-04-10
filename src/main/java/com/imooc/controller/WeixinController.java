package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/10
 * Time:20:21
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    @GetMapping("/auth")
    public void auth(@RequestParam("code")String code){
        log.info("进入auth方法。。。。");
        log.info("code={}",code);

        String url ="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx13f3127cf4b8d83b&secret=bf26e896c1f8a91ebabafdcad240045f&code="+code+"&grant_type=authorization_code";
         RestTemplate restTemplate=new RestTemplate();
         String  response =restTemplate.getForObject(url,String.class);
         log.info("response={}",response);
    }


}
