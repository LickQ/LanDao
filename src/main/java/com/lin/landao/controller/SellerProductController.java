package com.lin.landao.controller;

import com.lin.landao.entities.Category;
import com.lin.landao.entities.Product;
import com.lin.landao.exception.SellException;
import com.lin.landao.form.ProductForm;
import com.lin.landao.service.CategoryService;
import com.lin.landao.service.ProductService;
import com.lin.landao.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 卖家端商品
 */
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    //
    @Autowired
    public SellerProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    //
//    /**
//     * 列表
//     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size, Map<String, Object> map) {
        Integer innId=1;
        //todo
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Product> productInfoPage = productService.findList(request,innId);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("product/list", map);
    }
//
//    /**
//     * 商品上架
//     */
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId")Integer productId, Map<String, Object> map) {
        try {
            productService.onSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success", map);
    }
//    /**
//     * 商品下架
//     */
    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") Integer productId,
                                Map<String, Object> map) {
        try {
            productService.offSale(productId);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seller/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success", map);
    }
//
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) Integer productId, Map<String, Object> map) {
        if (!StringUtils.isEmpty(productId)) {
            Product product = productService.getProductById(productId);
            map.put("productInfo", product);
        }

        //查询所有的类目
        List<Category> categoryList = categoryService.queryCategoryAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("product/index", map);
    }
//
//    /**
//     * 保存/更新
//     */
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form, BindingResult bindingResult, Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        Product product = new Product();
        try {
            //如果productId为空, 说明是新增
            if (!StringUtils.isEmpty(form.getProductId())) {
                product= productService.getProductById(Integer.valueOf(form.getProductId()));
                BeanUtils.copyProperties(form, product);
                productService.updateProductById(product);
            } else {
                product.setInnId(1);
                BeanUtils.copyProperties(form, product);
                product.setProductStatus(0);
                product.setCreateTime(new Date());
                productService.create(product);
            }

        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
