package com.chongdong.ailiaoapp.service;

import com.chongdong.ailiaoapp.model.PointsRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.ailiaoapp.model.ResponseMap;

/**
* @author ASUS
* @description 针对表【tcd_points_record(积分记录表)】的数据库操作Service
* @createDate 2023-09-23 09:27:07
*/
public interface PointsRecordService extends IService<PointsRecord> {

    ResponseMap listPointsRecordByUserId(Long userId,String yearMonth);
}
