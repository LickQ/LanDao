package com.lin.landao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.landao.entities.Scenery;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
public interface SceneryService extends IService<Scenery> {
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
    //按热值排序返回的对象
    List<Scenery> querySceneryAllByHotValue();
    //根据坐标查询
//    Scenery getSceneryByCoordinate(Map map);
}
