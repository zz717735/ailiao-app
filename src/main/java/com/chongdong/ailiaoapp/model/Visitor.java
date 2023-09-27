package com.chongdong.ailiaoapp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 访客表
 * @TableName tcd_visitor
 */
@TableName(value ="tcd_visitor")
@Data
public class Visitor implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 访客id
     */
    @TableField(value = "visitor_id")
    private Long visitorId;

    /**
     * 被访者id
     */
    @TableField(value = "respondents_id")
    private Long respondentsId;

    /**
     * 访问时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 访问者查询
     * */
    @TableField(exist = false)
    private UserInfo userInfo;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}