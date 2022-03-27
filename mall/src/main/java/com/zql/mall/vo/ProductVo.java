package com.zql.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/21 - 12 - 21 - 15:40
 * @Description: com.zql.mall.vo
 * @version: 1.0
 */
@Data
public class ProductVo {

    private Integer id;

    private Integer categoryId;

    private String name;

    private String subtitle;

    private Integer status;

    private BigDecimal price;
}
