package com.lin.landao.service.impl;

import com.lin.landao.dao.StrategyMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.landao.entities.Strategy;
import com.lin.landao.service.StrategyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
@Service
public class StrategyServiceImpl extends ServiceImpl<StrategyMapper, Strategy> implements StrategyService {
    @Resource
    private StrategyMapper strategyMapper;
    //新增
    public int create(Strategy strategy){
        return strategyMapper.create(strategy);
    };

    //根据id查询
    public Strategy getStrategyById(Integer id){
        return strategyMapper.getStrategyById(id);
    };

    //查询所有
    public List<Strategy> queryStrategyAll(){
        return strategyMapper.queryStrategyAll();
    };

    //根据id删除
    public void deleteStrategyById(Integer id){
        strategyMapper.deleteStrategyById(id);
    };

}
