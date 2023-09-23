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

    @GetMapping
    public ResponseMap listComments(@RequestParam Long articleId,
                                    @RequestParam(defaultValue = "0") int articleType) {
        return commentService.listComments(articleId,articleType);
    }
    @PostMapping
    public ResponseMap addComment(@RequestBody @Valid Comment comment) {
        return commentService.addComment(comment);
    }
    @DeleteMapping("/{id}")
    public ResponseMap removeComment(@PathVariable Long id) {
        return commentService.removeComment(id);
    }
    @PutMapping("/praise")
    public ResponseMap updatePraiseNumByCommentId(Long commentId,Integer praiseNum){
        return commentService.updatePraiseNumByCommentId(commentId, praiseNum);
    }

}
