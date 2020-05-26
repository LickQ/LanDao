package com.lin.landao.controller;

import com.lin.landao.entities.Comment;
import com.lin.landao.entities.Inn;
import com.lin.landao.entities.Product;
import com.lin.landao.service.CommentService;
import com.lin.landao.service.InnService;
import com.lin.landao.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
public class BuyerProductController {
    @Resource
    private ProductService productService;
    @Resource
    private InnService innService;
    @Resource
    private CommentService commentService;
    @RequestMapping(value = "/productlist.action")
    public ModelAndView innList(Integer innId,HttpServletRequest requset, HttpServletResponse response) throws IOException {
        // 从Mysql中查询
        ModelAndView mav = new ModelAndView();
        Inn inns = innService.getInnById(innId);
        HashMap map= new HashMap();
        map.put("innId",innId);
        map.put("productStatus",1);
        List<Product> productlist = productService.getProductByInnIdAndStatus(map);
        List<Comment> comments = commentService.queryCommentAllByInnId(innId);
        mav.addObject("comments",comments);
        mav.addObject("inns",inns);
        mav.addObject("productlist", productlist);
        mav.setViewName("productlist");
        return mav;
    }

    @RequestMapping(value = "/productinfo.action")
    public ModelAndView productinfo(Integer productId) throws IOException {
        // 从Mysql中查询
        ModelAndView mav = new ModelAndView();
        Product product= productService.getProductById(productId);
        Integer innId = product.getInnId();
        Inn inn = innService.getInnById(innId);
        String innName=inn.getInnName();
        mav.addObject("innName",innName);
        mav.addObject("product", product);
        mav.setViewName("productinfo");
        return mav;
    }


}
