package com.lin.landao.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.landao.entities.Comment;
import org.apache.ibatis.annotations.Mapper;

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
public interface CommentMapper extends BaseMapper<Comment> {

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
