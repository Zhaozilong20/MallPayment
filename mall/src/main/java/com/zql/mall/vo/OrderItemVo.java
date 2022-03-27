package com.zql.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: ZhaoQL
 * @Date: 2022/1/6 - 01 - 06 - 16:07
 * @Description: com.zql.mall.vo
 * @version: 1.0
 */
@Data
public class OrderItemVo {

    private Long orderNo;

    private Integer productId;

    private String productName;

    private String productImage;

    private BigDecimal currentUnitPrice;

    private Integer quantity;

    private BigDecimal totalPrice;

    private Date createTime;
}
