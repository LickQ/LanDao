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
@ApiModel(value = "Inn对象", description = "")
public class Inn implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "inn_id", type = IdType.AUTO)
    private Integer innId;

    @TableField("inn_name")
    private String innName;

    @TableField("inn_address")
    private String innAddress;

    @TableField("inn_picture")
    private String innPicture;

    @TableField("inn_hotvalue")
    private Integer innHotvalue;

    @TableField("comment_id")
    private String commentId;


}
