package com.chongdong.ailiaoapp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 会员规则表
 * @TableName tcd_rule
 */
@TableName(value ="tcd_rule")
@Data
public class Rule implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 会员规则适用类型（0：女，1：男）
     */
    private Integer type;

    /**
     * 规则描述
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 修改时间
     */
    private Date edittime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}