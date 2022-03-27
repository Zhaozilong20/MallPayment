package com.zql.mall.service.impl;

import com.zql.mall.MallApplicationTests;
import com.zql.mall.dao.ShippingMapper;
import com.zql.mall.enums.ResponseEnum;
import com.zql.mall.form.ShippingForm;
import com.zql.mall.service.IShippingService;
import com.zql.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/27 - 12 - 27 - 19:51
 * @Description: com.zql.mall.service.impl
 * @version: 1.0
 */
@Slf4j
public class ShippingServiceImplTest extends MallApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private Integer uid = 1;
    private Integer shippingId;

    private ShippingForm form;

    @Before
    public void before(){

        ShippingForm form = new ShippingForm("赵子龙",
                "123456",
                "18812344321",
                "四川省",
                "成都市",
                "郫都区",
                "西南交大",
                "000123");
        this.form = form;

        add();
    }

    public void add() {

        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, form);
        log.info("result+{}", responseVo);
        this.shippingId = responseVo.getData().get("shippingId");
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());

    }

    @After
    public void delete() {
        ResponseVo responseVo = shippingService.delete(uid, shippingId);
        log.info("result+{}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());
    }

    @Test
    public void update() {
        form.setReceiverCity("上海");
        ResponseVo responseVo = shippingService.update(uid, shippingId, form);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());
    }

    @Test
    public void list() {
        ResponseVo responseVo = shippingService.list(uid, 1, 10);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());
    }
}