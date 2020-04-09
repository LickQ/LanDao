package com.lin.landao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.landao.entities.Admin;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
public interface AdminService extends IService<Admin> {
    //根据id查询
    Admin getAdminById(Integer id);
    //查询所有
    public List<Admin> queryAdminAll();
    //新增
    int create(Admin admin);
    //根据id删除
    void deleteAdminById(Integer id);
    //根据id修改
    void updateAdminById(Admin admin);

    Admin Adminlogin(String adminname,String password);
}
