package com.lin.landao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.landao.entities.Comment;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
public interface CommentService extends IService<Comment> {
    //根据id查询
    Comment getCommentById(Integer id);
    //新增
    int create(Comment comment);
    //查询所有
    List<Comment> queryCommentAll();

    //根据id删除
    void deleteCommentById(Integer id);
    //根据innid查询所有
    List<Comment> queryCommentAllByInnId(Integer innId);
    //根据strategyId查询所有
    List<Comment> queryCommentAllBystrategyId(Integer strategyId);
}
