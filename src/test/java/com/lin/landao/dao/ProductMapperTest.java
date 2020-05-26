package com.lin.landao.dao;

import com.lin.landao.dto.CartDTO;
import com.lin.landao.entities.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTest {
    @Resource
    private ProductMapper productMapper;

    @Test
    public void create() {
        Product product = new Product();
        product.setCategoryType("1");
        product.setInnId(1);
        product.setProductDescription("难吃");
        product.setProductIcon("asdsa");
        product.setProductName("青菜");
        product.setProductPrice(1);
        product.setProductStock(20);
        product.setProductStatus(2);
        product.setCreateTime(new Date());
        productMapper.create(product);
    }

    @Test
    public void getProductById() {
    }

    @Test
    public void getProductByStatus() {
        List<Product> productByStatus = productMapper.getProductByStatus(1);
        for (Product product:productByStatus){
            Assert.assertNotNull(product);
        }
    }


    @Test
    public void deleteProductById() {
    }

    @Test
    public void updateProductById() {
    }

    @Test
    public void increaseStock() {
        CartDTO cartDTO2 = new CartDTO(2,10);
        productMapper.increaseStock(cartDTO2);


    }

    @Test
    public void decreaseStock() {
        CartDTO cartDTO1 = new CartDTO(1,20);

        productMapper.decreaseStock(cartDTO1);
    }

    @Test
    public void getProductByInnIdAndStatus() {
        Integer innId=1;
        Integer productStatus=1;
        HashMap map= new HashMap();
        map.put("innId",innId);
        map.put("productStatus",productStatus);

        List<Product> productByInnIdAndStatus = productMapper.getProductByInnIdAndStatus(map);
        Assert.assertNotNull(productByInnIdAndStatus);
    }


}