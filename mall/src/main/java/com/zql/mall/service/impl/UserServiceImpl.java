package com.zql.mall.service.impl;

import com.zql.mall.dao.UserMapper;
import com.zql.mall.enums.RoleEnum;
import com.zql.mall.pojo.User;
import com.zql.mall.service.IUserService;
import com.zql.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

import static com.zql.mall.enums.ResponseEnum.*;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/17 - 12 - 17 - 13:52
 * @Description: com.zql.mall.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    /*
    *  注册
    *
    * */
    @Override
    public ResponseVo<User> register(User user) {

        //username不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if(countByUsername > 0){
            return ResponseVo.error(USERNAME_EXIST);
        }

        //email不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if(countByEmail > 0){
            return ResponseVo.error(EMAIL_EXIST);
        }

        //注册默认为顾客
        user.setRole(RoleEnum.CUSTOMER.getCode());

        //MD5摘要算法
        user.setPassword(DigestUtils.md5DigestAsHex(
                user.getPassword().getBytes(StandardCharsets.UTF_8)));

        //写入数据库
        int resultCount = userMapper.insertSelective(user);
        if(resultCount == 0){
            return ResponseVo.error(ERROR);
        }

        return ResponseVo.success();
    }

    @Override
    public ResponseVo<User> login(String username, String password) {

        User user = userMapper.selectByUsername(username);
        //用户名或密码错误
        if(user == null){
            //用户不存在
            return ResponseVo.error(USERNAME_OR_PASSWORD_ERROR);
        }
        if(!user.getPassword().equalsIgnoreCase(DigestUtils.md5DigestAsHex(
                      password.getBytes(StandardCharsets.UTF_8)))){
            //密码错误
            return ResponseVo.error(USERNAME_OR_PASSWORD_ERROR);
        }

        user.setPassword("");
        return ResponseVo.success(user);
    }

}
