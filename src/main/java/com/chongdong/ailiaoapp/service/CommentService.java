package com.chongdong.ailiaoapp.service;

import com.chongdong.ailiaoapp.model.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.ailiaoapp.model.ResponseMap;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;

/**
* @author ASUS
* @description 针对表【tcd_comment(评论表)】的数据库操作Service
* @createDate 2023-09-22 11:32:27
*/
@Validated
public interface CommentService extends IService<Comment> {

    ResponseMap listComments(Long articleId,Integer articleIdType);

    ResponseMap addComment(Comment comment);

    ResponseMap removeComment(Long id);

    ResponseMap updatePraiseNumByCommentId(Long commentId,@Min(value = 0,message = "点赞量不能为负数") Integer praiseNum);
}
