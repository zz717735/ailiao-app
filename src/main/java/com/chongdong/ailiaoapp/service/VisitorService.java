package com.chongdong.ailiaoapp.service;

import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.model.Visitor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author cd
* @description 针对表【tcd_visitor(访客表)】的数据库操作Service
* @createDate 2023-09-25 16:02:36
*/
public interface VisitorService extends IService<Visitor> {
    ResponseMap queryAllCountToday(Long respondentsId);
    ResponseMap queryAll(Long respondentsId);
    ResponseMap queryAllCount(Long respondentsId);
}
