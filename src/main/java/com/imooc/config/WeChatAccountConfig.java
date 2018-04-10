package com.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/10
 * Time:21:51
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;
}
