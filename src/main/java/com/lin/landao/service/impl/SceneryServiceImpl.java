package com.lin.landao.service.impl;

import com.lin.landao.dao.SceneryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.landao.entities.Scenery;
import com.lin.landao.service.SceneryService;
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
public class SceneryServiceImpl extends ServiceImpl<SceneryMapper, Scenery> implements SceneryService {
    @Resource
    private SceneryMapper sceneryMapper;

    //新增
    public int create(Scenery scenery){
        return sceneryMapper.create(scenery);
    };

    @Override
//    public Scenery getSceneryByCoordinate(Map map) {
//       return   sceneryMapper.getSceneryByCoordinate(map);
//    }

//    @Override
    public List<Scenery> querySceneryAllByHotValue() {
        return sceneryMapper.querySceneryAllByHotValue();
    }

    //根据id查询
    public Scenery getSceneryById(Integer id){
        return sceneryMapper.getSceneryById(id);
    };

    //查询所有
    public List<Scenery> querySceneryAll(){
        return sceneryMapper.querySceneryAll();
    };

    //根据id删除
    public void deleteSceneryById(Integer id){
        sceneryMapper.deleteSceneryById(id);
    };

    //根据id修改
    public void updateSceneryById(Scenery scenery){
        sceneryMapper.updateSceneryById(scenery);
    };

}
