package com.chongdong.ailiaoapp.controller;


import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.model.Rule;
import com.chongdong.ailiaoapp.service.RuleService;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Rule")
@Log4j
public class RuleController {
    @Resource
    private RuleService ruleService;

    //查询单个会员规则表
    @GetMapping("{id}")
    public ResponseMap selectRule(@PathVariable Integer id){
        return ruleService.selectOneRule(id);
    }

    //查询单个会员规则表(参数调试查看使用)
    @GetMapping("all")
    public ResponseMap selectAll(){
        return ruleService.selectAllRule();
    }
}
