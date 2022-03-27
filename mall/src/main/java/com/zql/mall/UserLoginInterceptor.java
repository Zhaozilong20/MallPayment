package com.zql.mall;

import com.zql.mall.exception.UserLoginException;
import com.zql.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.zql.mall.consts.MallConst.CURRENT_USER;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/18 - 12 - 18 - 16:21
 * @Description: com.zql.mall
 * @version: 1.0
 */
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    //true 表示继续流程
    //false 表示中断
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle ...");
        User user = (User) request.getSession().getAttribute(CURRENT_USER);
        if(user == null){
            log.info("user=null");
            throw new UserLoginException();
//            return false;
//            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
        }
        return true;
    }

}
