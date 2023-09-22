package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.Points;
import com.chongdong.ailiaoapp.service.PointsService;
import com.chongdong.ailiaoapp.mapper.PointsMapper;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【tcd_points(积分表)】的数据库操作Service实现
* @createDate 2023-09-22 11:32:27
*/
@Service
public class PointsServiceImpl extends ServiceImpl<PointsMapper, Points>
    implements PointsService{

}




