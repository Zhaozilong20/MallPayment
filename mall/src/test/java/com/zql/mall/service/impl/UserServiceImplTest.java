package com.zql.mall.service.impl;

import com.zql.mall.MallApplicationTests;
import com.zql.mall.enums.ResponseEnum;
import com.zql.mall.enums.RoleEnum;
import com.zql.mall.pojo.User;
import com.zql.mall.service.IUserService;
import com.zql.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.Response;

import static org.junit.Assert.*;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/17 - 12 - 17 - 14:11
 * @Description: com.zql.mall.service.impl
 * @version: 1.0
 */
@Transactional
public class UserServiceImplTest extends MallApplicationTests {

    private static final String USERNAME = "jack";
    private static final String PASSWORD = "123456";

    @Autowired
    private IUserService userService;

    @Before
    public void register() {
        User user = new User(USERNAME, PASSWORD, "jack@qq.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }

    @Test
    public void login(){
        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatues());
    }


}