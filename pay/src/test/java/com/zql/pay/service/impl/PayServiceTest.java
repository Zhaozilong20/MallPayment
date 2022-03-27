package com.zql.pay.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.zql.pay.PayApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/13 - 12 - 13 - 19:43
 * @Description: com.zql.pay.service.impl
 * @version: 1.0
 */
public class PayServiceTest extends PayApplicationTests {

    @Autowired
    private PayServiceImpl payService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void create() {
        payService.create("121312356", BigDecimal.valueOf(0.01), BestPayTypeEnum.WXPAY_NATIVE);
    }

    @Test
    public void sendMQMsg() {
        amqpTemplate.convertAndSend("payNotify", "hello");
    }
}