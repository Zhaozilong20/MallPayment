package com.zql.pay.enums;

import com.lly835.bestpay.enums.BestPayPlatformEnum;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import lombok.Getter;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/15 - 12 - 15 - 16:36
 * @Description: com.zql.pay.enums
 * @version: 1.0
 */
@Getter
public enum PayPlatformEnum {

    //支付平台:1-支付宝,2-微信
    ALIPAY(1),

    WX(2),
    ;

    Integer code;

    PayPlatformEnum(Integer code) {
        this.code = code;
    }

    public static PayPlatformEnum getByBestPayTypeEnum(BestPayTypeEnum bestPayTypeEnum){
        for (PayPlatformEnum payPlatformEnum : PayPlatformEnum.values()) {
            if(bestPayTypeEnum.getPlatform().name().equals(payPlatformEnum.name())){
                return payPlatformEnum;
            }
        }
        throw new RuntimeException("错误的支付平台 "+bestPayTypeEnum.name());
    }
}
