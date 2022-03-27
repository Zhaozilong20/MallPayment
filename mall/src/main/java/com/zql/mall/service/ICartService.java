package com.zql.mall.service;

import com.zql.mall.form.CartAddForm;
import com.zql.mall.form.CartUpdateForm;
import com.zql.mall.pojo.Cart;
import com.zql.mall.vo.CartProductVo;
import com.zql.mall.vo.CartVo;
import com.zql.mall.vo.ResponseVo;

import java.util.List;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/23 - 12 - 23 - 15:56
 * @Description: com.zql.mall.service
 * @version: 1.0
 */
public interface ICartService {

    ResponseVo<CartVo> add(Integer uid, CartAddForm form);

    ResponseVo<CartVo> list(Integer uid);

    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm form);

    ResponseVo<CartVo> delete(Integer uid, Integer productId);

    ResponseVo<CartVo> selectAll(Integer uid);

    ResponseVo<CartVo> unselectAll(Integer uid);

    ResponseVo<Integer> sum(Integer uid);

    List<Cart> listForCart(Integer uid);
}
