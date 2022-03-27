package com.zql.pay.service;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;
import com.zql.pay.pojo.PayInfo;

import java.math.BigDecimal;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/13 - 12 - 13 - 16:46
 * @Description: com.zql.pay.service
 * @version: 1.0
 */
public interface IPayService {

    /*
    * 创建/发起支付
    * */
    PayResponse create(String orderId, BigDecimal amount, BestPayTypeEnum bestPayTypeEnum);

    /*
    * 异步通知处理
    * */
    String asyncNotify(String notifyData);

    /*
    * 查询支付记录 通过订单号
    * */
    PayInfo queryByOrderId(String orderId);
}
