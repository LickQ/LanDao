package com.lin.landao.entities;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

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
@ApiModel(value = "Strategy对象", description = "")
public class Strategy implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "strategy_id", type = IdType.AUTO)
    private Integer strategyId;

    @TableField("strategy_title")
    private String strategyTitle;

    @TableField("strategy_summary")
    private String strategySummary;

    @TableField("strategy_detail")
    private String strategyDetail;

    @TableField("strategy_createtime")
    private Date strategyCreatetime;

    @TableField("strategy_checkmark")
    private String strategyCheckmark;

    @TableField("strategy_status")
    private Integer strategyStatus;

    @TableField("user_id")
    private Integer userId;

    @TableField("scenery_id")
    private Integer sceneryId;

    @TableField("comment_id")
    private Integer commentId;


}
