package com.chongdong.ailiaoapp.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.mapper.CommentMapper;
import com.chongdong.ailiaoapp.model.Comment;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.CommentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ASUS
 * @description 针对表【tcd_comment(评论表)】的数据库操作Service实现
 * @createDate 2023-09-22 11:32:27
 */
@Service
@Slf4j
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
        implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public ResponseMap listComments(Long articleId, Integer articleIdType) {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("article_id", articleId)
                .eq("article_type", articleIdType);
        List<Comment> commentList = this.baseMapper.selectList(queryWrapper);
        List<Tree<Long>> treeList = createCommentTree(commentList);
        return (!CollUtil.isEmpty(commentList)) ? ResponseMap.success(treeList) : ResponseMap.failure();
    }

    private static List<Tree<Long>> createCommentTree(List<Comment> commentList) {
        // 创建 TreeNodeConfig 配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setWeightKey("commentId"); // 设置节点权重字段，这里使用 commentId 作为权重
        // 构建菜单树
        return TreeUtil.build(commentList, null, treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getCommentId());
                    tree.setParentId(treeNode.getParentCommentId());
                    tree.setWeight(treeNode.getCommentId()); // 设置节点权重
                    tree.setName(treeNode.getCommentContent()); // 设置节点名称
                    tree.putExtra("userId", treeNode.getUserId());
                    tree.putExtra("articleId", treeNode.getArticleId());
                    tree.putExtra("articleType", treeNode.getArticleType());
                    tree.putExtra("praiseNum", treeNode.getPraiseNum());
                    tree.putExtra("topStatus", treeNode.getTopStatus());
                    tree.putExtra("parentCommentId", treeNode.getReplyCommentId());
                    tree.putExtra("parentCommentUserId", treeNode.getParentCommentUserId());
                    tree.putExtra("replyCommentId", treeNode.getReplyCommentId());
                    tree.putExtra("replyCommentUserId", treeNode.getReplyCommentUserId());
                    tree.putExtra("commentLeave", treeNode.getCommentLevel());
                    tree.putExtra("createTime", treeNode.getCreateTime());
                });
    }

    @Override
    public ResponseMap addComment(Comment comment) {
        int insert = this.baseMapper.insert(comment);
        return (insert > 0) ? ResponseMap.success() : ResponseMap.failure();
    }

    @Override
    public ResponseMap removeComment(Long id) {
        int deleteById = this.baseMapper.deleteById(id);
        return (deleteById > 0) ? ResponseMap.success() : ResponseMap.failure();
    }

    @Override
    public ResponseMap updatePraiseNumByCommentId(Long commentId, Integer praiseNum) {
        int updatePraiseNumByCommentId = commentMapper.updatePraiseNumByCommentId(praiseNum, commentId);
        return (updatePraiseNumByCommentId > 0) ? ResponseMap.success() : ResponseMap.failure();
    }
}




