package com.zql.mall.enums;

import lombok.Getter;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/17 - 12 - 17 - 14:20
 * @Description: com.zql.mall.enums
 * @version: 1.0
 */

public enum RoleEnum {
    ADMIN(0),

    CUSTOMER(1),

    ;

    Integer code;

    RoleEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
