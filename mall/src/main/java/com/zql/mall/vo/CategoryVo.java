package com.zql.mall.vo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/20 - 12 - 20 - 16:01
 * @Description: com.zql.mall.vo
 * @version: 1.0
 */
@Data
public class CategoryVo {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer sortOrder;

    private List<CategoryVo> subCategories;

}
