package com.chongdong.ailiaoapp.controller;

import com.chongdong.ailiaoapp.model.Points;
import com.chongdong.ailiaoapp.model.PointsRecord;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.PointsRecordService;
import com.chongdong.ailiaoapp.service.PointsService;
import com.chongdong.ailiaoapp.service.RuleService;
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
    private RuleService ruleService;
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

    /**
     * 查询个人总积分
     * @param userId 用户id
     * @return ResponseMap
     */
    @GetMapping
    public ResponseMap getPointsByUserId(@RequestParam Long userId){
        return pointsService.getPointsByUserId(userId);
    }

    /**
     * 查询积分记录
     * @param userId 用户id
     * @return ResponseMap
     */
    @GetMapping("pointsRecord")
    public ResponseMap listPointsRecord(@RequestParam Long userId,@RequestParam(defaultValue = "2023-09") String yearMonth){
        return pointsRecordService.listPointsRecordByUserId(userId,yearMonth);
    }

    /**
     * 查询积分规则表
     * @return ResponseMap
     */
    @GetMapping("pointsRule")
    public ResponseMap selectRule(@RequestParam(defaultValue = "4") Integer id){
        return ruleService.selectOneRule(id);
    }

}
