package com.zql.mall.listener;

import com.google.gson.Gson;
import com.zql.mall.pojo.PayInfo;
import com.zql.mall.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: ZhaoQL
 * @Date: 2022/2/11 - 02 - 11 - 0:01
 * @Description: com.zql.mall.listener
 * @version: 1.0
 */
/*
* 关于 payInfo正确姿势， pay项目提供client.jar, mall项目引用jar包
* */
@Component
@RabbitListener(queues = "payNotify")
@Slf4j
public class PayMsgListener {

    @Autowired
    private IOrderService orderService;

    @RabbitHandler
    public void process(String msg){
        log.info("接收到的消息 + {}", msg);
        PayInfo payInfo = new Gson().fromJson(msg, PayInfo.class);
        if(payInfo.getPlatformStatus().equals("SUCCESS")){
            //修改订单状态
            orderService.paid(payInfo.getOrderNo());
        }
    }
}
