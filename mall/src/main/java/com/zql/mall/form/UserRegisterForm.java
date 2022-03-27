package com.zql.mall.form;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/17 - 12 - 17 - 16:10
 * @Description: com.zql.mall.form
 * @version: 1.0
 */
@Data
public class UserRegisterForm {

//    @NotBlank 用于字符
//    @NotEmpty 用于集合
//    @NonNull
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;

}
