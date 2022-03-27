package com.zql.mall.pojo;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/23 - 12 - 23 - 16:11
 * @Description: com.zql.mall.pojo
 * @version: 1.0
 */
@Data
public class Cart {

    private Integer productId;

    private Integer quantity;

    private Boolean productSelected;

    public Cart() {
    }

    public Cart(Integer productId, Integer quantity, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSelected = productSelected;
    }
}
