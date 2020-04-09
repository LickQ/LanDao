package com.lin.landao.service.impl;

import com.lin.landao.dao.InnMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.landao.entities.Inn;
import com.lin.landao.service.InnService;
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
public class InnServiceImpl extends ServiceImpl<InnMapper, Inn> implements InnService {
    @Resource
    private InnMapper innMapper;
    //新增
    public int create(Inn inn){
        return innMapper.create(inn);
    };

    //根据id查询
    public Inn getInnById(Integer id){
        return innMapper.getInnById(id);
    };

    //查询所有
    public List<Inn> queryInnAll(){
        return innMapper.queryInnAll();
    };

    //根据id删除
    public void deleteInnById(Integer id){
        innMapper.deleteInnById(id);
    };

    //根据id修改
    public void updateInnById(Inn inn){
        innMapper.updateInnById(inn);
    };
}
