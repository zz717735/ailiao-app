package com.chongdong.ailiaoapp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 礼物表
 * @TableName tcd_gift
 */
@TableName(value ="tcd_gift")
@Data
public class Gift implements Serializable {
    /**
     * 礼物编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 礼物名称
     */
    private String name;

    /**
     * 礼物图片路径
     */
    private String path;

    /**
     * 礼物价格
     */
    private BigDecimal price;

    /**
     * 礼物创建时间
     */
    private LocalDateTime createTime;

    /**
     * 礼物类型
     */
    private Integer typeId;

    /**
     * 礼物修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 礼物状态1：上架 0：下架
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}