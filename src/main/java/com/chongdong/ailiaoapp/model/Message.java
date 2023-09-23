package com.chongdong.ailiaoapp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 信息表
 * @TableName tcd_message
 */
@TableName(value ="tcd_message")
@Data
public class Message implements Serializable {
    /**
     * 信息编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色：1：普通用户，2：特殊用户
     */
    @TableField(value = "role")
    private Integer role;

    /**
     * 消息类型：文字、图片、语音、视频
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 消息内容
     */
    @TableField(value = "message")
    private String message;

    /**
     * 消息发送者
     */
    @TableField(value = "come_from")
    private Long comeFrom;

    /**
     * 消息接受者
     */
    @TableField(value = "from_to")
    private Long fromTo;

    /**
     * 消息真实接受者
     */
    @TableField(value = "sender")
    private Long sender;

    /**
     * 消息发送时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}