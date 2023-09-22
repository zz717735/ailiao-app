package com.chongdong.ailiaoapp.controller;

import com.chongdong.ailiaoapp.model.Report;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.ReportService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Resource
    ReportService reportService;
    /**
     * 添加举报信息
     * */
    @PostMapping
    public ResponseMap addReport(@RequestBody Report report){
        return reportService.addReport(report);
    }
}
