package com.imooc.utils;

import java.util.Random;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/8
 * Time:21:13
 */


public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式：时间加随机数
     * @return
     */
    public static String genUniqueKey(){
        Random random =new Random();
        Integer number=   random.nextInt(900000)+100000;
        return  System.currentTimeMillis()+String.valueOf(number);

    }
}
