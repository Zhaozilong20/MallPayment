package com.zql.mall.service.impl;

import com.github.pagehelper.PageInfo;
import com.zql.mall.MallApplicationTests;
import com.zql.mall.enums.ResponseEnum;
import com.zql.mall.pojo.PayInfo;
import com.zql.mall.service.IProductService;
import com.zql.mall.vo.ProductDetailVo;
import com.zql.mall.vo.ProductVo;
import com.zql.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/21 - 12 - 21 - 16:41
 * @Description: com.zql.mall.service.impl
 * @version: 1.0
 */
public class ProductServiceImplTest extends MallApplicationTests {

    @Autowired
    private IProductService productService;

    @Test
    public void list() {
        ResponseVo<PageInfo> responseVo = productService.list(null, 2, 1);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());
    }

    @Test
    public void detail(){
        ResponseVo<ProductDetailVo> responseVo = productService.detail(26);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());
    }

}