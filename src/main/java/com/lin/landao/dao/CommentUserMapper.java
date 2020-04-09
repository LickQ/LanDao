package com.lin.landao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.landao.entities.Comment;
import com.lin.landao.entities.CommentUser;
import com.lin.landao.entities.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentUserMapper extends BaseMapper<CommentUser> {
    //根据id查询
//    Comment getCommentUserById(Integer id);
    //查询所有
    List<Comment> queryCommentUserAll();


    //    查询user的信息和该user的所以comment信息
    List<User> queryUserCommentsAll();


}
