package com.chongdong.ailiaoapp.mapper;

import com.chongdong.ailiaoapp.model.Visitor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_visitor(访客表)】的数据库操作Mapper
* @createDate 2023-09-25 16:02:36
* @Entity com.chongdong.ailiaoapp.model.Visitor
*/
public interface VisitorMapper extends BaseMapper<Visitor> {
    List<Visitor> queryAllById(Long respondentsId);
}




