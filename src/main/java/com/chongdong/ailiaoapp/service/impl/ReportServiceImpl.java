package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.Report;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.ReportService;
import com.chongdong.ailiaoapp.mapper.ReportMapper;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author cd
* @description 针对表【tcd_report(举报信息)】的数据库操作Service实现
* @createDate 2023-09-22 09:50:22
*/
@Service
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report>
    implements ReportService{
    @Resource
    ResponseMapUtil<Report> responseMapUtil;
    /**
     * 添加举报信息
     * */
    @Override
    public ResponseMap addReport(Report report) {
        report.setCreateTime(new Date());
        return responseMapUtil.addEntity(this.save(report));
    }
}




