package com.zql.mall.controller;

import com.github.pagehelper.PageInfo;
import com.zql.mall.consts.MallConst;
import com.zql.mall.form.OrderCreateForm;
import com.zql.mall.pojo.Order;
import com.zql.mall.pojo.PayInfo;
import com.zql.mall.pojo.User;
import com.zql.mall.service.IOrderService;
import com.zql.mall.vo.OrderVo;
import com.zql.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Auther: ZhaoQL
 * @Date: 2022/2/10 - 02 - 10 - 20:56
 * @Description: com.zql.mall.controller
 * @version: 1.0
 */

@RestController
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/orders")
    public ResponseVo<OrderVo> create(@Valid @RequestBody OrderCreateForm form,
                                      HttpSession session){
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.create(user.getId(), form.getShippingId());
    }

    @GetMapping("/orders")
    public ResponseVo<PageInfo> list(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                     HttpSession session){
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.list(user.getId(),pageNum,pageSize);
    }

    @GetMapping("/orders/{orderNo}")
    public ResponseVo<OrderVo> detail(@PathVariable Long orderNo,
                                      HttpSession session){
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.detail(user.getId(),orderNo);
    }

    @PutMapping("/orders/{orderNo}")
    public ResponseVo<OrderVo> cancel(@PathVariable Long orderNo,
                                      HttpSession session){
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return orderService.cancel(user.getId(),orderNo);
    }

}
