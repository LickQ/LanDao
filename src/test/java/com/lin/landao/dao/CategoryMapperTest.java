package com.lin.landao.dao;

import com.lin.landao.entities.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryMapperTest {
    @Resource
    private CategoryMapper categoryMapper;


    @Test
    public void getCategoryById() {
        Category categoryById = categoryMapper.getCategoryById(1);
        System.out.println(categoryById);
        Assert.assertNotNull(categoryById);
    }
    @Test
    public void getCategoryBytype() {
        Category categoryByType = categoryMapper.getCategoryByType("1");
        Assert.assertNotNull(categoryByType);
    }

    @Test
    public void create() {
        Category category = new Category();
        category.setCategoryName("特色");
        category.setCategoryType("2");
        category.setInnId(1);
        category.setCreateTime(new Date());
        categoryMapper.create(category);

    }

    @Test
    public void queryCategoryAll() {
        List<Category> categories = categoryMapper.queryCategoryAll();
        Assert.assertNotNull(categories);
    }

    @Test
    public void deleteCategoryById() {
        categoryMapper.deleteCategoryById(2);

    }

    @Test
    public void updateCategoryById() {
        Category category = new Category();
        category.setCategoryName("热门");
        category.setCategoryType("1");
        category.setInnId(1);
        category.setUpdateTime(new Date());
        category.setCategoryId(3);
        categoryMapper.updateCategoryById(category);
    }
}