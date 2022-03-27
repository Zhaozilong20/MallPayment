package com.zql.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/18 - 12 - 18 - 14:02
 * @Description: com.zql.mall.form
 * @version: 1.0
 */
@Data
public class UserLoginForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
