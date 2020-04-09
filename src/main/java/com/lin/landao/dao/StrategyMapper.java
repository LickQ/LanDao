package com.lin.landao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.landao.entities.Strategy;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
public interface StrategyMapper extends BaseMapper<Strategy> {
    //新增
    int create(Strategy strategy);

    //根据id查询
    Strategy getStrategyById(Integer id);

    //查询所有
    List<Strategy> queryStrategyAll();

    //根据id删除
    void deleteStrategyById(Integer id);

    //根据id修改
//    void updateStrategyById(Strategy strategy);
}
