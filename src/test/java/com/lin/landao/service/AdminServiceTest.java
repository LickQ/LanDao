package com.lin.landao.service;

import com.lin.landao.dao.AdminMapper;
import com.lin.landao.dao.CommentUserMapper;
import com.lin.landao.entities.Admin;
import com.lin.landao.entities.Comment;
import com.lin.landao.entities.CommentUser;
import com.lin.landao.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
    @Resource
    private CommentUserMapper commentUserMapper;
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private AdminService adminService;

    @Test
    public void getAdminServiceById() {

        Admin adminById = adminService.getAdminById(1);
        Assert.assertNotNull(adminById);
    }

    @Test
    public void getAdminById() {

        Admin adminById = adminMapper.getAdminById(1);

        Assert.assertNotNull(adminById);
    }

    @Test
    public void queryAdminAll() {
        List<Admin> admins = adminMapper.queryAdminAll();
        Assert.assertNotNull(admins);
    }

    @Test
    public void queryCommnetUserAll() {
//        List<Comment> comments = commentUserMapper.queryCommentUserAll();
//        Assert.assertNotNull(comments);
//        for (Comment comment: comments){
//            System.out.println(comment);
//            System.out.println(comment.getUser());
//        }

    }

    @Test
    public void queryUserCommnetAll() {
//        List<User> users = commentUserMapper.queryUserCommentsAll();
//        for (User user:users){
//            System.out.println(user);
//            System.out.println(user.getComments());
//        }
    }

    @Test
    public void creat() {
        Admin admin = new Admin();
        admin.setAdminName("nihao");
        admin.setAdminPassword("123");
        admin.setInnId(1);
        int i = adminMapper.create(admin);
        System.out.println(i);
    }

    @Test
    public void deleteAdminById() {
        adminMapper.deleteAdminById(2);
    }

    @Test
    public void updatAdminById() {
        Admin admin = new Admin();
        admin.setAdminName("wwhao");
        admin.setAdminPassword("123");
        admin.setInnId(1);
        admin.setAdminId(1);
        adminMapper.updateAdminById(admin);
    }

}