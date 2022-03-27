package com.zql.mall.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zql.mall.MallApplicationTests;
import com.zql.mall.enums.ResponseEnum;
import com.zql.mall.form.CartAddForm;
import com.zql.mall.form.CartUpdateForm;
import com.zql.mall.service.ICartService;
import com.zql.mall.vo.CartVo;
import com.zql.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/23 - 12 - 23 - 16:21
 * @Description: com.zql.mall.service.impl
 * @version: 1.0
 */
@Slf4j
public class CartServiceImplTest extends MallApplicationTests {

    @Autowired
    private ICartService cartService;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Integer productId = 27;

    private Integer uid = 1;

    @Test
    public void add() {
        log.info("【新增购物车】...");
        CartAddForm form = new CartAddForm();
        form.setProductId(productId);
        form.setSelected(true);
        ResponseVo<CartVo> responseVo = cartService.add(uid, form);
        log.info("add+{}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());
    }

    @Test
    public void list() {
        ResponseVo<CartVo> responseVo = cartService.list(uid);
        log.info("list+{}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());
    }

    @Test
    public void update() {
        CartUpdateForm form = new CartUpdateForm();
        form.setQuantity(5);
        form.setSelected(true);
        ResponseVo<CartVo> responseVo = cartService.update(uid, productId,form);
        log.info("update+{}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());
    }

    @Test
    public void delete() {
        log.info("【删除购物车】...");
        ResponseVo<CartVo> responseVo = cartService.delete(uid, productId);
        log.info("delete+{}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());
    }

    @Test
    public void selectAll() {
        ResponseVo<CartVo> responseVo = cartService.selectAll(uid);
        log.info("result+{}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());
    }

    @Test
    public void unselectAll() {
        ResponseVo<CartVo> responseVo = cartService.unselectAll(uid);
        log.info("result+{}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());
    }

    @Test
    public void sum() {
        ResponseVo<Integer> responseVo = cartService.sum(uid);
        log.info("result+{}",gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());
    }
}