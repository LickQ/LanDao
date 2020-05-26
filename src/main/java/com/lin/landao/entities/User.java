package com.lin.landao.entities;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;


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
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    //    主表实体包含从表实体的集合
//    private List<Comment> comments;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @TableField("user_name")
    private String userName;

    @TableField("user_telephone")
    private String userTelephone;

    @TableField("user_age")
    private Integer userAge;

    @TableField("user_rname")
    private String userRname;

    @TableField("user_sex")
    private String userSex;

    @TableField("user_password")
    private String userPassword;


}
