package com.lin.landao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.landao.entities.Category;
import com.lin.landao.entities.NavDirectory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    //根据id查询
    Category getCategoryById(Integer id);
    //根据type查询
    Category getCategoryByType(String type);
    //新增
    int create(Category category);
    // 查询所有
    List<Category> queryCategoryAllById(Integer id);
    List<Category> queryCategoryAll();
    //    根据id删除
    void deleteCategoryById(Integer id);

    //    根据id修改
    void updateCategoryById(Category category);

    //查询所有
    List<NavDirectory> queryNavDirectoryAll();

}
