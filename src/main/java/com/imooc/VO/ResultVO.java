package com.imooc.VO;

import lombok.Data;

/**
 * HTTP请求返回的最外层对象
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/6
 * Time:13:17
 */
@Data
public class ResultVO<T> {
    /**错误码 */
    private Integer code;
    /**提示信息 .*/
    private String msg;
    /**具体内容 .*/
    private T data;
}
