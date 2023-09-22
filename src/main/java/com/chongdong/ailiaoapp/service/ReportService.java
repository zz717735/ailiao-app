package com.chongdong.ailiaoapp.service;

import com.chongdong.ailiaoapp.model.Report;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.ailiaoapp.model.ResponseMap;

/**
* @author cd
* @description 针对表【tcd_report(举报信息)】的数据库操作Service
* @createDate 2023-09-22 09:50:22
*/
public interface ReportService extends IService<Report> {
    /**
     * 添加举报信息
     * */
    ResponseMap addReport(Report report);
}
