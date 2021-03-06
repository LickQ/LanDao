package com.lin.landao.service.impl;

import com.lin.landao.dao.ProductMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.landao.dto.CartDTO;
import com.lin.landao.entities.OrderPage;
import com.lin.landao.entities.Product;
import com.lin.landao.enums.ProductStatusEnum;
import com.lin.landao.enums.ResultEnum;
import com.lin.landao.exception.SellException;
import com.lin.landao.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Resource
    private ProductMapper productMapper;

    //新增
    public int create(Product product) {
        return productMapper.create(product);
    }

    ;

    @Override
    public List<Product> getProductByInnId(Integer innId) {
        return productMapper.getProductByInnId(innId);
    }

    @Override
    public List<Product> getProductByInnIdAndStatus(Map map) {
        return productMapper.getProductByInnIdAndStatus(map);
    }

    //返回分页对象
    @Override
    public Page<Product> findList(Pageable pageable, Integer innId) {
        OrderPage orderPage = new OrderPage(pageable.getOffset(), pageable.getPageSize(), innId);
        List<Product> items = productMapper.findAll(orderPage);
        int totol = productMapper.countAll(innId);
        Page result = new PageImpl(items, pageable, totol);
        return result;

    }

    //根据id查询
    public Product getProductById(Integer id) {
        return productMapper.getProductById(id);
    }

    ;

    @Override
    public List<Product> getProductByStatus(Integer status) {
        return productMapper.getProductByStatus(status);
    }

    @Override
    public List<Product> findUpAll() {
        return productMapper.getProductByStatus(ProductStatusEnum.UP.getCode());
    }

    //查询所有
    public List<Product> queryProductAll() {
        return productMapper.queryProductAll();
    }

    ;

    //根据id删除
    public void deleteProductById(Integer id) {
        productMapper.deleteProductById(id);
    }

    ;

    //根据id修改
    public void updateProductById(Product product) {
        productMapper.updateProductById(product);
    }

    ;

    //加库存
    @Override
    public void increaseStock(CartDTO cartDTO) {
        Product productInfo = productMapper.getProductById(cartDTO.getProductId());
        if (productInfo == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        productMapper.increaseStock(cartDTO);
    }

    //减库存
    @Override
    public void decreaseStock(CartDTO cartDTO) {
        Product productById = productMapper.getProductById(cartDTO.getProductId());
        if (productById == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        Integer result;
        result = productById.getProductStock() - cartDTO.getProductQuantity();
        if (result < 0) {
            throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
        }

        productMapper.decreaseStock(cartDTO);
    }

    @Override
    public void onSale(Integer productId) {
        Product product = productMapper.getProductById(productId);
        if (product == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (product.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新
        product.setProductStatus(ProductStatusEnum.UP.getCode());
        productMapper.updateProductById(product);
    }

    @Override
    public void offSale(Integer productId) {
        Product product = productMapper.getProductById(productId);
        if (product == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (product.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新
        product.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productMapper.updateProductById(product);
    }
}
