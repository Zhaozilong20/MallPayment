package com.zql.mall.dao;

import com.zql.mall.pojo.Product;
import com.zql.mall.vo.ProductVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ProductMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectByCategoryIdSet(@Param("categoryIdSet") Set<Integer> categoryIdSet);

    //todo 根据set返回list
    List<Product> selectByProductIdSet(@Param("productIdSet") Set<Integer> productIdSet);
}