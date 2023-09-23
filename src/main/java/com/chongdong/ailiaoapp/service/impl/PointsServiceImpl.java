package com.chongdong.ailiaoapp.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.mapper.PointsRecordMapper;
import com.chongdong.ailiaoapp.model.Points;
import com.chongdong.ailiaoapp.model.PointsRecord;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.PointsService;
import com.chongdong.ailiaoapp.mapper.PointsMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ASUS
 * @description 针对表【tcd_points(积分表)】的数据库操作Service实现
 * @createDate 2023-09-22 11:32:27
 */
@Slf4j
@Service
public class PointsServiceImpl extends ServiceImpl<PointsMapper, Points>
        implements PointsService {
    @Resource
    private PointsMapper pointsMapper;
    @Resource
    private PointsRecordMapper pointsRecordMapper;

    @Override
    public ResponseMap updateTotalPointsByUserId(Long userId, Integer addPoints,String pointsActivity) {
        Points oneByUserId = this.pointsMapper.selectOneByUserId(userId);
        if (ObjectUtil.isNull(oneByUserId)) {
            return ResponseMap.failure().message("用户不存在");
        }
        Integer totalPoints = oneByUserId.getTotalPoints();
        totalPoints = totalPoints + addPoints;
        oneByUserId.setTotalPoints(totalPoints);
        Map<String, Object> points = MapUtil.builder(new HashMap<String, Object>()).put("userId", userId)
                .put("totalPoints", totalPoints).build();
        int updateTotalPointsByUserId = this.pointsMapper.updateTotalPointsByUserId(totalPoints, userId);
        PointsRecord pointsRecord = PointsRecord.builder().userId(userId).pointsChange(addPoints).createTime(LocalDateTime.now()).pointsActivity(pointsActivity).build();
        int insert = pointsRecordMapper.insert(pointsRecord);
        return (updateTotalPointsByUserId > 0) ? ResponseMap.success(points) : ResponseMap.failure();
    }

    @Override
    public ResponseMap getPointsByUserId(Long userId) {
        log.info("{}",userId);
        QueryWrapper<Points> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        Points selectOne = this.baseMapper.selectOne(queryWrapper);
        log.info("{}",selectOne.toString());
        return (ObjectUtil.isNotEmpty(selectOne)) ? ResponseMap.success(selectOne) : ResponseMap.failure().data("没有该用户的积分记录");
    }
}




