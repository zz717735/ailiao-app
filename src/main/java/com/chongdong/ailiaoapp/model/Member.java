package com.chongdong.ailiaoapp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 会员等级表
 * @TableName tcd_member
 */
@TableName(value ="tcd_member")
@Data
public class Member implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 会员等级
     */
    private String grade;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 修改时间
     */
    private Date modifytime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}