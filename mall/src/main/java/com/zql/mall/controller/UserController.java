package com.zql.mall.controller;

import com.zql.mall.enums.ResponseEnum;
import com.zql.mall.form.UserLoginForm;
import com.zql.mall.form.UserRegisterForm;
import com.zql.mall.pojo.User;
import com.zql.mall.service.IUserService;
import com.zql.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.ws.Response;

import java.util.Objects;

import static com.zql.mall.consts.MallConst.CURRENT_USER;
import static com.zql.mall.enums.ResponseEnum.PARAM_ERROR;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/17 - 12 - 17 - 15:11
 * @Description: com.zql.mall.controller
 * @version: 1.0
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user/register")
    //     前端对应json格式 @RequestBody
    //     前端对应数据格式urlencoded @RequestParam
    public ResponseVo register(@Valid @RequestBody UserRegisterForm userForm){

        /*if(bindingResult.hasFieldErrors()){
            log.error("注册提交的参数有误，{} {}",
                    Objects.requireNonNull(bindingResult.getFieldError()).getField(),
                    bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(PARAM_ERROR, bindingResult);
        }*/

        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        //dto
        return userService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
                                  HttpSession session){
        /*if(bindingResult.hasFieldErrors()){
            return ResponseVo.error(PARAM_ERROR, bindingResult);
        }*/

        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());

        //设置Session
        session.setAttribute(CURRENT_USER, userResponseVo.getData());
        log.info("/login sessionId={}", session.getId());

        return userResponseVo;
    }

    //session保存在内存里， token+redis
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session){

        log.info("/user sessionId={}", session.getId());
        User user = (User) session.getAttribute(CURRENT_USER);
        return ResponseVo.success(user);
    }

    /**
     * {@link TomcatServletWebServerFactory} getSessionTimeoutInMinutes
     */
    @PostMapping("/user/logout")
    public ResponseVo<User> logout(HttpSession session){
        log.info("/user/logout sessionId={}", session.getId());
        session.removeAttribute(CURRENT_USER);
        return ResponseVo.successByMsg("退出成功");
    }

}
