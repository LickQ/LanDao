package com.lin.landao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.landao.entities.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    //新增
    int create(Admin admin);

    //根据id查询
    Admin getAdminById(Integer id);

    //查询所有
    List<Admin> queryAdminAll();

    //根据id删除
    void deleteAdminById(Integer id);

    //根据id修改
    void updateAdminById(Admin admin);


    Admin Adminlogin(String adminname,String password);

}
