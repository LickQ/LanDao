package com.lin.landao.service.impl;

import com.lin.landao.dao.CommentMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.landao.entities.Comment;
import com.lin.landao.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    //根据id查询
    public Comment getCommentById(Integer id){
        return  commentMapper.getCommentById(id);
    }
    //新增
    public int create(Comment comment){
        return commentMapper.create(comment);
    }
    //查询所有
    public List<Comment> queryCommentAll(){
        return commentMapper.queryCommentAll();
    };

    //根据id删除
    public void deleteCommentById(Integer id){
        commentMapper.deleteCommentById(id);
    };
}
