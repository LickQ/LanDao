package com.lin.landao.service.impl;

import com.lin.landao.dao.AdminMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.landao.entities.Admin;
import com.lin.landao.service.AdminService;
import org.junit.Test;
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
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    //根据id查询
    public Admin getAdminById(Integer id){
        return  adminMapper.getAdminById(id);
    }
    //查询所有
    public  List<Admin> queryAdminAll(){
        List<Admin> admins = adminMapper.queryAdminAll();
        return admins;
    }

    @Override
    public Admin getAdminByName(String adminName) {
        return adminMapper.getAdminByName(adminName);
    }

    //根据id删除
    public void deleteAdminById(Integer id){
       adminMapper.deleteAdminById(id);
    }

    //根据id修改
    public void updateAdminById(Admin admin){
        adminMapper.updateAdminById(admin);
    }
    //新增
    public int create(Admin admin){
        return  adminMapper.create(admin);
    }

    @Override
    public Admin Adminlogin(String adminname, String password) {
    return  adminMapper.Adminlogin(adminname,password);
    }
}
