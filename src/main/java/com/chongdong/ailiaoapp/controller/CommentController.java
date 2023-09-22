package com.chongdong.ailiaoapp.controller;

import com.chongdong.ailiaoapp.service.CommentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("comment")
public class CommentController {
    @Resource
    private CommentService commentService;
}
