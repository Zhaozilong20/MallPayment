package com.zql.mall.dao;

import com.zql.mall.MallApplicationTests;
import com.zql.mall.pojo.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/17 - 12 - 17 - 14:45
 * @Description: com.zql.mall.dao
 * @version: 1.0
 */
public class OrderMapperTest extends MallApplicationTests {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {

        Order order = orderMapper.selectByPrimaryKey(1);
        System.out.println(order.toString());

    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}