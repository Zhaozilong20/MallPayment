package com.zql.mall.form;

import lombok.Data;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/24 - 12 - 24 - 16:02
 * @Description: com.zql.mall.form
 * @version: 1.0
 */
@Data
public class CartUpdateForm {

    private Integer quantity; //非必填

    private Boolean selected; //非必填

}
