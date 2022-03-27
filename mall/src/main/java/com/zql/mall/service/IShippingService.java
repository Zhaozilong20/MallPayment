package com.zql.mall.service;

import com.github.pagehelper.PageInfo;
import com.sun.javaws.jnl.ResourcesDesc;
import com.zql.mall.form.ShippingForm;
import com.zql.mall.pojo.PayInfo;
import com.zql.mall.pojo.Shipping;
import com.zql.mall.vo.ResponseVo;

import java.util.Map;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/27 - 12 - 27 - 17:20
 * @Description: com.zql.mall.service
 * @version: 1.0
 */
public interface IShippingService {

    ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm form);

    ResponseVo delete(Integer uid, Integer shippingId);

    ResponseVo update(Integer uid, Integer shippingId, ShippingForm form);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);

}
