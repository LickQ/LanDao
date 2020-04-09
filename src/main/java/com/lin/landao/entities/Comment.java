package com.lin.landao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author Lfy
 * @since 2020-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Comment对象", description = "")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    //从表实体应该包含一个主表实体的对象引用
    private User user;
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    @TableField("comment_detail")
    private String commentDetail;

    @TableField("comment_status")
    private Integer commentStatus;

    @TableField("user_id")
    private Integer userId;

}
