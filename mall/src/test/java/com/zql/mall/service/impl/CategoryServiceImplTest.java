package com.zql.mall.service.impl;

import com.zql.mall.MallApplicationTests;
import com.zql.mall.enums.ResponseEnum;
import com.zql.mall.service.ICategoryService;
import com.zql.mall.vo.CategoryVo;
import com.zql.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.rmi.runtime.Log;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/20 - 12 - 20 - 20:17
 * @Description: com.zql.mall.service.impl
 * @version: 1.0
 */
@Slf4j
public class CategoryServiceImplTest extends MallApplicationTests {

    @Autowired
    private ICategoryService categoryService;

    @Test
    public void selectAll() {
        ResponseVo<List<CategoryVo>> responseVo = categoryService.selectAll();
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());
    }

    @Test
    public void findSubCategoryId(){
        Set<Integer> resultSet = new HashSet<>();
        categoryService.findSubCategoryId(100001, resultSet);
        log.info("set = {}",resultSet);
    }

}