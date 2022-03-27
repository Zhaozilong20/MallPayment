package com.zql.mall.service;

import com.github.pagehelper.PageInfo;
import com.zql.mall.vo.OrderVo;
import com.zql.mall.vo.ResponseVo;
import org.springframework.stereotype.Service;

/**
 * @Auther: ZhaoQL
 * @Date: 2022/1/6 - 01 - 06 - 16:11
 * @Description: com.zql.mall.service
 * @version: 1.0
 */
public interface IOrderService {

    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);

    ResponseVo<OrderVo> detail(Integer uid, Long orderNo);

    ResponseVo cancel(Integer uid, Long orderNo);

    void paid(Long orderNo);

}
