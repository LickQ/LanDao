package com.lin.landao.controller;

import com.lin.landao.entities.Category;
import com.lin.landao.exception.SellException;
import com.lin.landao.form.CategoryForm;
import com.lin.landao.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 卖家类目
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    private final CategoryService categoryService;

    @Autowired
    public SellerCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
//
//    /**
//     * 类目列表
//     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        Integer innId=1;
        List<Category> categoryList = categoryService.queryCategoryAllById(innId);
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }
//
//    /**
//     * 展示
//     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId, Map<String, Object> map) {
        if (categoryId != null) {
            Category productCategory = categoryService.getCategoryById(categoryId);
            map.put("category", productCategory);
        }
        return new ModelAndView("category/index", map);
    }
//
//    /**
//     * 保存/更新
//     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form, BindingResult bindingResult, Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        Category productCategory = new Category();
        try {
            if (form.getCategoryId() != null) {
                productCategory = categoryService.getCategoryById(form.getCategoryId());
                BeanUtils.copyProperties(form, productCategory);
                categoryService.updateCategoryById(productCategory);
            }
            else {
                //todo
                productCategory.setInnId(1);
                productCategory.setCreateTime(new Date());
                productCategory.setUpdateTime(new Date());
                BeanUtils.copyProperties(form, productCategory);
                categoryService.create(productCategory);

            }
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/seller/category/list");
        return new ModelAndView("common/success", map);
    }
}
