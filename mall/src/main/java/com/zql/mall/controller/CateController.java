package com.zql.mall.controller;

import com.zql.mall.service.ICategoryService;
import com.zql.mall.vo.CategoryVo;
import com.zql.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/20 - 12 - 20 - 16:54
 * @Description: com.zql.mall.controller
 * @version: 1.0
 */
@RestController
public class CateController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/categories")
    public ResponseVo<List<CategoryVo>> selectAll(){
        return categoryService.selectAll();
    }
}
