package com.chongdong.ailiaoapp.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 评论表
 * @TableName tcd_comment
 */
@TableName(value ="tcd_comment")
@Data
public class Comment implements Serializable {
    /**
     * 评论id
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    /**
     * 评论内容
     */
    @TableField(value = "comment_content")
    private String commentContent;

    /**
     * 评论人id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 在哪篇文章（动态）下评论的
     */
    @TableField(value = "article_id")
    private Long articleId;

    /**
     * 文章类型（0动态，1相册，2其他）
     */
    @TableField(value = "article_type")
    private Integer articleType;

    /**
     * 评论是否非法 1(非法)，0(合法)
     */
    @TableField(value = "illegal")
    private Integer illegal;

    /**
     * 父级评论id
     */
    @TableField(value = "parent_comment_id")
    private Long parentCommentId;

    /**
     * 父级评论的user_id
     */
    @TableField(value = "parent_comment_user_id")
    private Long parentCommentUserId;

    /**
     * 被回复的评论id
     */
    @TableField(value = "reply_comment_id")
    private Long replyCommentId;

    /**
     * 被回复的评论的user_id
     */
    @TableField(value = "reply_comment_user_id")
    private Long replyCommentUserId;

    /**
     * 评论等级[ 1 一级评论 默认 ，2 二级评论]
     */
    @TableField(value = "comment_level")
    private Integer commentLevel;

    /**
     * 评论的点赞数量
     */
    @TableField(value = "praise_num")
    private Integer praiseNum;

    /**
     * 置顶状态[ 1 置顶，0 不置顶 默认 ]
     */
    @TableField(value = "top_status")
    private Integer topStatus;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}