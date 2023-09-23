package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.mapper.TrendsMapper;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.model.Trends;
import com.chongdong.ailiaoapp.model.TrendsLike;
import com.chongdong.ailiaoapp.service.TrendsLikeService;
import com.chongdong.ailiaoapp.mapper.TrendsLikeMapper;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author cd
* @description 针对表【tcd_trends_like(动态点赞表)】的数据库操作Service实现
* @createDate 2023-09-23 11:42:41
*/
@Service
public class TrendsLikeServiceImpl extends ServiceImpl<TrendsLikeMapper, TrendsLike>
    implements TrendsLikeService{
    @Resource
    private TrendsLikeMapper trendsLikeMapper;
    @Resource
    private ResponseMapUtil<TrendsLike> responseMapUtil;
    @Resource
    private TrendsMapper trendsMapper;

    @Override
    public ResponseMap likeTrends(TrendsLike trendsLike) {
        QueryWrapper<TrendsLike> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("like_people_id",trendsLike.getLikePeopleId());
        queryWrapper.eq("trends_id",trendsLike.getTrendsId());
        TrendsLike trendsLike1 = trendsLikeMapper.selectOne(queryWrapper);
        if (trendsLike1==null){
            Trends trends = trendsMapper.selectById(trendsLike.getTrendsId());
            trends.setCount(trends.getCount()+1);
            trendsLike.setCreateTime(new Date());
            trendsMapper.update(trends,new QueryWrapper<Trends>().eq("id",trends.getId()));
            return responseMapUtil.updateOrAddEntity(trendsLikeMapper.insert(trendsLike));
        }else {
           return responseMapUtil.updateOrAddEntity(-1);
        }
    }
}




