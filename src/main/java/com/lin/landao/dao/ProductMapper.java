package com.lin.landao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.landao.dto.CartDTO;
import com.lin.landao.entities.OrderPage;
import com.lin.landao.entities.Product;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
public interface ProductMapper extends BaseMapper<Product> {
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

    //加库存
    void increaseStock(CartDTO cartDTO);

    //减库存
    void decreaseStock(CartDTO cartDTO);

    List<Product> findAll(OrderPage orderPage);

    int countAll(Integer innId);
    //根据innId查询
    List<Product> getProductByInnId(Integer innId);
    //根据innId和状态查询
    List<Product> getProductByInnIdAndStatus(Map map);

}
