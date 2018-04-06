package com.imooc.controller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created with IDEA
 * author:学习编程的shou
 * Date:2018/4/6
 * Time:13:12
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有上架商品
        List<ProductInfo> productInfoList= productService.findOnsaleAll();

        //2.查询类目 （一次性查询）
       // List<Integer> categoryTypeList= new ArrayList<>();
        //传统方法
//        for(ProductInfo productInfo:productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }

        //精简方法 （lambda表达式）     从所有上架商品中 将里面的类目type全都 遍历出来  变成一个数字LIst
        List<Integer> categoryTypeList=productInfoList.stream()
                .map(e->e.getCategoryType())
                .collect(Collectors.toList());
        //通过得到的 数字List 使用类别Service中的 findByCategoryTypeIn方法 得到<ProductCategory>List
        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);


        //3.数据拼装          通过得到的这些  完整的 实体类  我们可以通过对这些实体类对象进行数据拼装  以实现 要求的 数据展示
/*
        {
            "code": 0,
                "msg": "成功",
                "data": [
            {
                "name": "热榜",
                    "type": 1,
                    "foods": [
                {
                    "id": "123456",
                        "name": "皮蛋粥",
                        "price": 1.2,
                        "description": "好吃的皮蛋粥",
                        "icon": "http://xxx.com",
                }
            ]

    ]
        }        */    //先通过遍历   类别实体列表   把数据注入
        List<ProductVO> productVOList=new ArrayList<>();
        for(ProductCategory productCategory:productCategoryList){
            ProductVO productVO =new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

                                //一个productVO中还要包含 类别中的 美食  所以通过遍历 和判断  把该类别的 美食 加入到该productVO中
                List<ProductInfoVO> productInfoVOList =new ArrayList<>();
                for(ProductInfo productInfo:productInfoList){
                    if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                        ProductInfoVO productInfoVO =new ProductInfoVO();
                        BeanUtils.copyProperties(productInfo,productInfoVO);  //通过BeanUtils的copyProperties方法  可以将 大实体类中的小实体类属性注进去
                        productInfoVOList.add(productInfoVO);
                    }
                }
            productVO.setProductInfoVOList(productInfoVOList);
         productVOList.add(productVO);
        }


        ResultVO resultVO=new ResultVO();
        ProductVO productVO=new ProductVO();
        ProductInfoVO productInfoVO=new ProductInfoVO();

        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
        resultVO.setData(Arrays.asList(productVO));
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(productVO);

        return resultVO;


    }


}
