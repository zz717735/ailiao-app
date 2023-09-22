package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.model.Rule;
import com.chongdong.ailiaoapp.model.Trends;
import com.chongdong.ailiaoapp.service.RuleService;
import com.chongdong.ailiaoapp.mapper.RuleMapper;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import jakarta.annotation.Resource;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_rule(会员规则表)】的数据库操作Service实现
* @createDate 2023-09-22 10:53:04
*/
@Service
public class RuleServiceImpl extends ServiceImpl<RuleMapper, Rule>
    implements RuleService{
    @Resource
    ResponseMapUtil<Rule> responseMapUtil;
    @Resource
    RuleMapper ruleMapper;

    @Override
    public ResponseMap selectOneRule(Integer id) {
        QueryWrapper<Rule> wrapper = new QueryWrapper<>();
        Rule rule=ruleMapper.selectOne(wrapper.eq("id",id));
        return responseMapUtil.getEntity(rule);
    }

    @Override
    public String addOrEditOne(Rule rule) {
        return "对不起，你没有权限！！！赶紧走吧！！";
    }

    @Override
    public ResponseMap selectAllRule() {
        List<Rule> rules = ruleMapper.selectList(new QueryWrapper<Rule>().select());
        return responseMapUtil.getList(rules);
    }
}




