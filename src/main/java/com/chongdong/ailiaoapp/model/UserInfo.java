package com.chongdong.ailiaoapp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 
 * @TableName tcd_user_info
 */
@TableName(value ="tcd_user_info")
@Data
public class UserInfo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long infoId;

    /**
     * 用户性别：0：男，1女
     */
    private Integer gender;

    /**
     * 个性标签
     */
    private String labels;

    /**
     * 头像图片路径
     */
    private String headPath;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 职称
     */
    private String jobTitle;

    /**
     * 地区
     */
    private String region;

    /**
     * 语言介绍
     */
    private String introduction;

    /**
     * 点赞数量
     */
    private Integer likeNumber;

    /**
     * 个人描述
     */
    private String description;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * 微信号
     */
    private String chatLogin;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户状态：0：冻结，1：解冻
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}