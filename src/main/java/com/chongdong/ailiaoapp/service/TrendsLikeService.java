package com.chongdong.ailiaoapp.service;

import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.model.TrendsLike;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author cd
* @description 针对表【tcd_trends_like(动态点赞表)】的数据库操作Service
* @createDate 2023-09-23 11:42:41
*/
public interface TrendsLikeService extends IService<TrendsLike> {

    ResponseMap likeTrends(TrendsLike trendsLike);
}
