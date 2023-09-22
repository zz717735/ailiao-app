package com.chongdong.ailiaoapp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 礼物接收表
 * @TableName tcd_gift_receive
 */
@TableName(value ="tcd_gift_receive")
@Data
public class GiftReceive implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 接收者id
     */
    private Long receiver;

    /**
     * 赠送者id
     */
    private Long giver;

    /**
     * 礼物id
     */
    private Integer giftId;

    /**
     * 礼物赠送时间
     */
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}