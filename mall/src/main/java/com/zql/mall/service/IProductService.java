package com.zql.mall.service;

import com.github.pagehelper.PageInfo;
import com.zql.mall.vo.ProductDetailVo;
import com.zql.mall.vo.ResponseVo;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/21 - 12 - 21 - 15:42
 * @Description: com.zql.mall.service
 * @version: 1.0
 */

public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);

}
