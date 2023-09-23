package com.chongdong.ailiaoapp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

/**
 * 积分记录表
 * @TableName tcd_points_record
 */
@TableName(value ="tcd_points_record")
@Data
@Builder
public class PointsRecord implements Serializable {
    /**
     * 积分记录id
     */
    @TableId(value = "points_record_id", type = IdType.AUTO)
    private Long pointsRecordId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 积分变化
     */
    @TableField(value = "points_change")
    private Integer pointsChange;

    /**
     * 积分变化的活动/日常/任务【名称】
     */
    @TableField(value = "points_activity")
    private String pointsActivity;

    /**
     * 变化时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}