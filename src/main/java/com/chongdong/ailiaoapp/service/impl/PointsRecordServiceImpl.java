package com.chongdong.ailiaoapp.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.PointsRecord;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.PointsRecordService;
import com.chongdong.ailiaoapp.mapper.PointsRecordMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ASUS
 * @description 针对表【tcd_points_record(积分记录表)】的数据库操作Service实现
 * @createDate 2023-09-23 09:27:07
 */
@Service
public class PointsRecordServiceImpl extends ServiceImpl<PointsRecordMapper, PointsRecord>
        implements PointsRecordService {

    @Override
    public ResponseMap listPointsRecordByUserId(Long userId,String yearMonth) {
        QueryWrapper<PointsRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.apply(StringUtils.isNotBlank(yearMonth), "DATE_FORMAT(create_time, '%Y-%m') = {0}", yearMonth);
        queryWrapper.orderByAsc("create_time");
        List<PointsRecord> pointsRecordList = this.baseMapper.selectList(queryWrapper);
        return (CollUtil.isNotEmpty(pointsRecordList)) ? ResponseMap.success(pointsRecordList) : ResponseMap.failure().data("没有该月份记录");
    }
}




