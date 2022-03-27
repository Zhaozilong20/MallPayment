package com.zql.mall.service;

import com.zql.mall.pojo.User;
import com.zql.mall.vo.ResponseVo;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/17 - 12 - 17 - 13:48
 * @Description: com.zql.mall.service
 * @version: 1.0
 */
public interface IUserService {

    /*
    * 注册
    * */
    ResponseVo<User> register(User user);

    /*
    * 登录
    * */
    ResponseVo<User> login(String username, String password);
}
