package com.zql.mall.enums;

import lombok.Getter;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/21 - 12 - 21 - 21:20
 * @Description: com.zql.mall.enums
 * @version: 1.0
 */
@Getter
public enum ProductStatusEnum {

    ON_SALE(1),

    OFF_SALE(2),

    DELETE(3),

    ;

    Integer code;

    ProductStatusEnum(Integer code) {
        this.code = code;
    }
}
