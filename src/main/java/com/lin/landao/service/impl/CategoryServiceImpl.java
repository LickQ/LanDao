package com.lin.landao.service.impl;

import com.lin.landao.dao.CategoryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.landao.entities.Category;
import com.lin.landao.entities.NavDirectory;
import com.lin.landao.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//
///**
// * <p>
// * 服务实现类
// * </p>
// *
// * @author Lfy
// * @since 2020-03-23
// */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    //根据id查询
    public Category getCategoryById(Integer id) {
        return categoryMapper.getCategoryById(id);
    }

    //新增
    public int create(Category category) {
        return categoryMapper.create(category);
    }

    @Override
    public List<NavDirectory> queryNavDirectoryAll() {
        return categoryMapper.queryNavDirectoryAll();
    }

    // 查询所有
    public List<Category> queryCategoryAllById(Integer id) {
        return categoryMapper.queryCategoryAllById(id);
    }

    public List<Category> queryCategoryAll() {
        return categoryMapper.queryCategoryAll();
    }

    //    根据id删除
    public void deleteCategoryById(Integer id) {
        categoryMapper.deleteCategoryById(id);
    }

    //    根据id修改
    public void updateCategoryById(Category category) {
        categoryMapper.updateCategoryById(category);
    }
}
