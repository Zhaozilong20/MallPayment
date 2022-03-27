package com.zql.mall.enums;

import lombok.Getter;

/**
 * @Auther: ZhaoQL
 * @Date: 2022/2/8 - 02 - 08 - 9:37
 * @Description: com.zql.mall.enums
 * @version: 1.0
 */
@Getter
public enum PaymentTypeEnum {
    PAY_ONLINE(1),
    ;
    Integer code;

    PaymentTypeEnum(Integer code) {
        this.code = code;
    }
}
