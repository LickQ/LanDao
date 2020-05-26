package com.lin.landao.service;

import com.lin.landao.dao.ProductMapper;
import com.lin.landao.entities.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Resource
    private  ProductService productService;
    @Resource
    private ProductMapper productMapper;
    @Test
    public void getProductByInnId() {
        List<Product> productByInnId = productMapper.getProductByInnId(1);
//        Product productByInnId = productService.getProductByInnId(1);
        Assert.assertNotNull(productByInnId);
    }
}