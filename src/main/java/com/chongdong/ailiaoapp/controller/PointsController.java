package com.chongdong.ailiaoapp.controller;

import com.chongdong.ailiaoapp.model.Points;
import com.chongdong.ailiaoapp.model.PointsRecord;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.PointsRecordService;
import com.chongdong.ailiaoapp.service.PointsService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("points")
public class PointsController {
    @Resource
    private PointsService pointsService;
    @Resource
    private PointsRecordService pointsRecordService;

    /**
     * 修改总积分
     * @param userId 用户id
     * @param addPoints 积分增量
     * @return Result
     */
    @PutMapping("/addPoints")
    public ResponseMap addPoints(@RequestParam Long userId,@RequestParam Integer addPoints,@RequestParam(defaultValue = "日常") String pointsActivity){
        return pointsService.updateTotalPointsByUserId(userId,addPoints,pointsActivity);
    }
    @GetMapping
    public ResponseMap getPointsByUserId(@RequestParam Long userId){
        return pointsService.getPointsByUserId(userId);
    }
    @GetMapping("pointsRecord")
    public ResponseMap listPointsRecord(@RequestParam Long userId){
        return pointsRecordService.listPointsRecordByUserId(userId);
    }

}
