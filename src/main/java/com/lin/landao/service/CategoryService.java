package com.lin.landao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.landao.entities.Category;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
public interface CategoryService extends IService<Category> {
    //根据id查询
    Category getCategoryById(Integer id);
    //新增
    int create(Category category);
    // 查询所有
    List<Category> queryCategoryAll();

    //    根据id删除
    void deleteCategoryById(Integer id);

    //    根据id修改
    void updateCategoryById(Category category);
}
