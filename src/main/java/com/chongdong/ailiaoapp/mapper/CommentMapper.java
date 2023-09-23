package com.chongdong.ailiaoapp.mapper;

import com.chongdong.ailiaoapp.model.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author ASUS
* @description 针对表【tcd_comment(评论表)】的数据库操作Mapper
* @createDate 2023-09-22 11:32:27
* @Entity com.chongdong.ailiaoapp.model.Comment
*/
public interface CommentMapper extends BaseMapper<Comment> {
    int updatePraiseNumByCommentId(@Param("praiseNum") Integer praiseNum, @Param("commentId") Long commentId);
}




