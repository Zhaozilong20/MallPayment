package com.zql.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/22 - 12 - 22 - 17:26
 * @Description: com.zql.mall.form
 * @version: 1.0
 */

public class CartAddForm {

    @NotNull
    private Integer productId;

    private boolean selected = true;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public CartAddForm(@NotNull Integer productId, boolean selected) {
        this.productId = productId;
        this.selected = selected;
    }

    public CartAddForm() {
    }
}
