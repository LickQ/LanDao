package com.lin.landao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.landao.entities.User;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
public interface UserService extends IService<User> {
    //新增
    int create(User user);

    //根据id查询
    User getUserById(Integer id);

    //查询所有
    List<User> queryUserAll();

    //根据id删除
    void deleteUserById(Integer id);

    //根据id修改
    void updateUserById(User user);

    User getUserByUserName(String userName);
}
