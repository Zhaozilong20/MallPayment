package com.zql.mall.service.impl;

import com.zql.mall.dao.CategoryMapper;
import com.zql.mall.pojo.Category;
import com.zql.mall.service.ICategoryService;
import com.zql.mall.vo.CategoryVo;
import com.zql.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.zql.mall.consts.MallConst.ROOT_PARENT_ID;

/**
 * @Auther: ZhaoQL
 * @Date: 2021/12/20 - 12 - 20 - 16:40
 * @Description: com.zql.mall.service.impl
 * @version: 1.0
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 耗时：http(请求微信api) > 磁盘 > 内存
     * mysql(内网+磁盘)
     * @return
     */
    @Override
    public ResponseVo<List<CategoryVo>> selectAll() {

        List<Category> categories = categoryMapper.selectAll();

        //查出parent_id 为 0
//        for (Category category : categories) {
////            if(category.getParentId().equals(ROOT_PARENT_ID)){
////                CategoryVo categoryVo = new CategoryVo();
////                BeanUtils.copyProperties(category, categoryVo);
////                categoryVoList.add(categoryVo);
////            }
////        }

        //lambda + stream
        List<CategoryVo> categoryVoList = categories.stream()
                .filter(e -> e.getParentId().equals(ROOT_PARENT_ID))
                .map(this::category2CategoryVo)
                .sorted(Comparator.comparing(CategoryVo::getSortOrder).reversed())
                .collect(Collectors.toList());

        //查询子目录
        findSubCategory(categoryVoList,categories);

        return ResponseVo.success(categoryVoList);
    }

    @Override
    public void findSubCategoryId(Integer id, Set<Integer> resultSet) {
        List<Category> categories = categoryMapper.selectAll();
        findSubCategoryId(id,resultSet,categories);
    }

    private void findSubCategoryId(Integer id, Set<Integer> resultSet, List<Category> categories) {
        for (Category category : categories) {
            if(category.getParentId().equals(id)){
                resultSet.add(category.getId());
                findSubCategoryId(category.getId(),resultSet,categories);
            }
        }
    }

    public void findSubCategory(List<CategoryVo> categoryVoList, List<Category> categories){

        //大类查询
        for (CategoryVo categoryVo : categoryVoList) {
            List<CategoryVo> subCategoryVoList = new ArrayList<>();
            //根据大类的ID 和 全品类的父ID查询
            for (Category category : categories) {
                //如果查到内容 继续往下查
                if(categoryVo.getId().equals(category.getParentId())){
                    CategoryVo subCategoryVo = category2CategoryVo(category);
                    subCategoryVoList.add(subCategoryVo);
                }

                subCategoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
                categoryVo.setSubCategories(subCategoryVoList);
                //递归  二级目录查询
                findSubCategory(subCategoryVoList, categories);
            }
        }

    }

    public CategoryVo category2CategoryVo(Category category){

        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;

    }


}
