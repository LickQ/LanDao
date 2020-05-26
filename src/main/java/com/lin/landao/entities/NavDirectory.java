package com.lin.landao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "navDirectory对象", description = "")
public class NavDirectory{

    @TableId(value = "nav_id", type = IdType.AUTO)
    private Integer navId;
    @TableField("nav_name")
    private String navName;
    @TableField("nav_suffix")
    private String navSuffix;

}
