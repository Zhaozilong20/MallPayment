package com.zql.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Auther: ZhaoQL
 * @Date: 2022/2/10 - 02 - 10 - 21:01
 * @Description: com.zql.mall.form
 * @version: 1.0
 */
@Data
public class OrderCreateForm {

    @NotNull
    private Integer shippingId;
}
