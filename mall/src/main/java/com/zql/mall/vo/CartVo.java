package com.zql.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/22 - 12 - 22 - 17:19
 * @Description: com.zql.mall.vo
 * @version: 1.0
 */
@Data
public class CartVo {

    private List<CartProductVo> cartProductVoList;

    private boolean selectedAll;

    private BigDecimal cartTotalPrice;

    private Integer cartTotalQuantity;

}
