package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.factory.EntityFactory;
import com.chongdong.ailiaoapp.model.Relationship;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.RelationshipService;
import com.chongdong.ailiaoapp.mapper.RelationshipMapper;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import com.chongdong.ailiaoapp.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
* @author cd
* @description 针对表【tcd_relationship(好友关系表)】的数据库操作Service实现
* @createDate 2023-09-22 11:42:43
*/
@Service
public class RelationshipServiceImpl extends ServiceImpl<RelationshipMapper, Relationship>
    implements RelationshipService{
    @Resource
    ResponseMapUtil<Object> responseMapUtil;
    @Resource
    private RedisTemplate<Object,Object> redisTemplate;

    @Override
    public ResponseMap add(Relationship relationship) {

        relationship.setChecking(1);
        relationship.setCreateTime(new Date());
        redisTemplate.opsForValue().set("ownerId",relationship);
        Object ownerId = redisTemplate.opsForValue().get("ownerId");
        return responseMapUtil.getEntity(ownerId);
    }

    @Override
    public ResponseMap update(Relationship relationship) {
        return responseMapUtil.updateEntity(this.updateById(relationship));
    }

}




