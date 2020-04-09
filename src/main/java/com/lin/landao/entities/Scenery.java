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
@ApiModel(value = "Scenery对象", description = "")
public class Scenery implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "scenery_id", type = IdType.AUTO)
    private Integer sceneryId;

    @TableField("scenery_name")
    private String sceneryName;

    @TableField("scenery_picture")
    private String sceneryPicture;

    @TableField("scenery_hotvalue")
    private Integer sceneryHotvalue;

    @TableField("scenery_address")
    private String sceneryAddress;


}
