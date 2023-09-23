package com.chongdong.ailiaoapp.mapper;

import com.chongdong.ailiaoapp.model.Points;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author ASUS
* @description 针对表【tcd_points(积分表)】的数据库操作Mapper
* @createDate 2023-09-22 11:32:27
* @Entity com.chongdong.ailiaoapp.model.Points
*/
public interface PointsMapper extends BaseMapper<Points> {
    Points selectOneByUserId(@Param("userId") Long userId);
    int updateTotalPointsByUserId(@Param("totalPoints") Integer totalPoints, @Param("userId") Long userId);
}




