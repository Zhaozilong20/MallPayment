package com.zql.mall.service;

import com.zql.mall.vo.CategoryVo;
import com.zql.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/20 - 12 - 20 - 16:04
 * @Description: com.zql.mall.service
 * @version: 1.0
 */
public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();

    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
