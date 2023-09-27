package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.model.UserInfo;
import com.chongdong.ailiaoapp.model.Visitor;
import com.chongdong.ailiaoapp.service.VisitorService;
import com.chongdong.ailiaoapp.mapper.VisitorMapper;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_visitor(访客表)】的数据库操作Service实现
* @createDate 2023-09-25 16:02:36
*/
@Service
public class VisitorServiceImpl extends ServiceImpl<VisitorMapper, Visitor>
    implements VisitorService{
    @Resource
    private ResponseMapUtil<Visitor> responseMapUtil;
    @Resource
    private VisitorMapper visitorMapper;

    @Override
    public ResponseMap queryAllCountToday(Long respondentsId) {
        List<Visitor> visitors = visitorMapper.queryAllById(respondentsId);
        return responseMapUtil.queryCountEntity(visitors.stream().count());
    }

    @Override
    public ResponseMap queryAll(Long respondentsId) {
        return responseMapUtil.getList(visitorMapper.queryAllById(respondentsId));
    }

    @Override
    public ResponseMap queryAllCount(Long respondentsId) {
        QueryWrapper<Visitor> wrapper = new QueryWrapper<>();
        wrapper.eq("respondents_id",respondentsId);
        List<Visitor> visitors = visitorMapper.selectList(wrapper);
        return responseMapUtil.queryCountEntity(visitors.stream().count());
    }
}




