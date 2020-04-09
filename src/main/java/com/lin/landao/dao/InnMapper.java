package com.lin.landao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.landao.entities.Inn;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
public interface InnMapper extends BaseMapper<Inn> {
    //新增
    int create(Inn inn);

    //根据id查询
    Inn getInnById(Integer id);

    //查询所有
    List<Inn> queryInnAll();

    //根据id删除
    void deleteInnById(Integer id);

    //根据id修改
    void updateInnById(Inn inn);
}
