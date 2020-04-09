package com.lin.landao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.landao.dto.CartDTO;
import com.lin.landao.entities.Product;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
public interface ProductService extends IService<Product> {
    //新增
    int create(Product product);

    //根据id查询
    Product getProductById(Integer id);

    //根据status查询
    List<Product> getProductByStatus(Integer status);

    //查询所有
    List<Product> queryProductAll();

    //根据id删除
    void deleteProductById(Integer id);

    //根据id修改
    void updateProductById(Product product);

    //查询所有在架商品列表
    List<Product> findUpAll();
    //加库存
    void increaseStock(CartDTO cartDTO);

    //减库存
    void decreaseStock(CartDTO cartDTO);

}
