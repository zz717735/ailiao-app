package com.chongdong.ailiaoapp.controller;

import com.chongdong.ailiaoapp.model.Relationship;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.RelationshipService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relationship")
public class RelationshipController {
    @Resource
    private RelationshipService relationshipService;

    /**
     * 添加好友
     * */
    @PostMapping("/add")
    public ResponseMap add(@RequestBody Relationship relationship){
        return relationshipService.add(relationship);
    }
    /**
     * 同意好友申请
     * */
    @PutMapping("/update")
    public ResponseMap update(@RequestBody Relationship relationship){
        return relationshipService.update(relationship);
    }


}
