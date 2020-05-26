package com.lin.landao.service.impl;

import com.lin.landao.entities.User;
import com.lin.landao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void create() {
        User user = new User();
        user.setUserAge(1);
        user.setUserName("wan");
        user.setUserPassword("123");
        user.setUserRname("王出");
        user.setUserTelephone("12345678901");
        userService.create(user);
    }
}