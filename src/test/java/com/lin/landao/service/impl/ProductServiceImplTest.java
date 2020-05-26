package com.lin.landao.service.impl;

import com.lin.landao.entities.Product;
import com.lin.landao.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductServiceImplTest {

    @Resource
    private ProductService productService;
    @Test
    public void findList() {
        PageRequest request = PageRequest.of(1-1, 4);
        Page<Product> list = productService.findList(request, 1);
        Assert.assertNotNull(list);

    }
}