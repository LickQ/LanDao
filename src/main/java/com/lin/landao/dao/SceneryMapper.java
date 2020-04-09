package com.lin.landao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.landao.entities.Scenery;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
public interface SceneryMapper extends BaseMapper<Scenery> {
    //新增
    int create(Scenery scenery);

    //根据id查询
    Scenery getSceneryById(Integer id);

    //查询所有
    List<Scenery> querySceneryAll();

    //根据id删除
    void deleteSceneryById(Integer id);

    //根据id修改
    void updateSceneryById(Scenery scenery);
}
