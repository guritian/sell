package com.imooc.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/12
 * Time:14:09
 */
public class JsonUtil {
    public static String toJson(Object object){
        GsonBuilder gsonBuilder =new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson =gsonBuilder.create();
        return  gson.toJson(object);
    }
}
