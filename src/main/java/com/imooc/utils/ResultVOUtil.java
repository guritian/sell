package com.imooc.utils;

import com.imooc.VO.ResultVO;

/**
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/6
 * Time:19:41
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO =new ResultVO();
        resultVO.setData(object);
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        return resultVO;
    }
    public static ResultVO success(){
        return success(null);
    }
    public static ResultVO error(Integer code,String msg ){
        ResultVO resultVO =new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }
}
