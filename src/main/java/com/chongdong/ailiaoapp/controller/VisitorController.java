package com.chongdong.ailiaoapp.controller;

import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.VisitorService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitor")
public class VisitorController {
    @Resource
    private VisitorService visitorService;
    /**
     * 查看今日访客量
     * */
    @GetMapping("/queryAllCountToday")
    public ResponseMap queryAllCountToday(@RequestParam Long infoId){
        return visitorService.queryAllCountToday(infoId);
    }
    /**
     * 查看今日访客
     * */
    @GetMapping("/queryAll")
    public ResponseMap queryAll(@RequestParam Long infoId){
        return visitorService.queryAll(infoId);
    }

    /**
     * 查看总访客量
     * */
    @GetMapping("/queryAllCount")
    public ResponseMap queryAllCount(@RequestParam Long infoId){
        return visitorService.queryAllCount(infoId);
    }

}
