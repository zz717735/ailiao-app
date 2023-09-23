package com.chongdong.ailiaoapp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 积分表
 * @TableName tcd_points
 */
@TableName(value ="tcd_points")
@Data
public class Points implements Serializable {
    /**
     * 积分id
     */
    @TableId(value = "points_id", type = IdType.AUTO)
    private Long pointsId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 总积分
     */
    @TableField(value = "total_points")
    private Integer totalPoints;

    /**
     * 当前等级
     */
    @TableField(value = "current_level")
    private String currentLevel;

    /**
     * 折扣率
     */
    @TableField(value = "discount_rate")
    private Integer discountRate;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 最后级别更新（评定）日期
     */
    @TableField(value = "last_level_update_date")
    private LocalDateTime lastLevelUpdateDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}