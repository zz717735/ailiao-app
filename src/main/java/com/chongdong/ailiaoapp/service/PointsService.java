package com.chongdong.ailiaoapp.service;

import com.chongdong.ailiaoapp.model.Points;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.ailiaoapp.model.ResponseMap;

/**
* @author ASUS
* @description 针对表【tcd_points(积分表)】的数据库操作Service
* @createDate 2023-09-22 11:32:27
*/
public interface PointsService extends IService<Points> {

    ResponseMap updateTotalPointsByUserId(Long userId, Integer addPoints,String pointsActivity);

    ResponseMap getPointsByUserId(Long userId);
}
