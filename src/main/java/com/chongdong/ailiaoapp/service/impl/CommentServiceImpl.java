package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.Comment;
import com.chongdong.ailiaoapp.service.CommentService;
import com.chongdong.ailiaoapp.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【tcd_comment(评论表)】的数据库操作Service实现
* @createDate 2023-09-22 11:32:27
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




