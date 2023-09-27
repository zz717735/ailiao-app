package com.chongdong.ailiaoapp.controller;

import com.chongdong.ailiaoapp.model.Comment;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.CommentService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    /**
     * 评论列表
     * */
    @GetMapping
    public ResponseMap listComments(@RequestParam Long articleId,
                                    @RequestParam(defaultValue = "0") int articleType) {
        return commentService.listComments(articleId,articleType);
    }
    /**
     * 添加评论
     * */
    @PostMapping
    public ResponseMap addComment(@RequestBody @Valid Comment comment) {
        return commentService.addComment(comment);
    }
    /**
     * 删除评论
     * */
    @DeleteMapping("/{id}")
    public ResponseMap removeComment(@PathVariable Long id) {
        return commentService.removeComment(id);
    }
    /**
     * 更新评论点赞数量
     * */
    @PutMapping("/praise")
    public ResponseMap updatePraiseNumByCommentId(Long commentId,Integer praiseNum){
        return commentService.updatePraiseNumByCommentId(commentId, praiseNum);
    }

}
