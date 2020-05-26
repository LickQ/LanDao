package com.lin.landao.service.impl;

import com.lin.landao.dao.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.landao.entities.User;
import com.lin.landao.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }

    //新增
    public int create(User user) {
        return userMapper.create(user);
    }

    ;

    //根据id查询
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    ;

    //查询所有
    public List<User> queryUserAll() {
        return userMapper.queryUserAll();
    }

    ;

    //根据id删除
    public void deleteUserById(Integer id) {
        userMapper.deleteUserById(id);
    }

    ;

    //根据id修改
    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }

    ;
}