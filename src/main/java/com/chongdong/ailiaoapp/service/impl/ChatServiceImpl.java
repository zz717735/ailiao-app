package com.chongdong.ailiaoapp.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chongdong.ailiaoapp.model.Message;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.ChatService;
import com.chongdong.ailiaoapp.vo.ChatVO;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class ChatServiceImpl implements ChatService {
    @Resource
    private RedisTemplate<Object, Object> redisTemplate;
    @Override
    public ResponseMap listChatAndMessages(Long userId) {
        List<Long> comFormList = new ArrayList<>();
        BoundListOperations<Object, Object> myUnread = redisTemplate.boundListOps("unread" + userId);
        BoundListOperations<Object, Object> myRead = redisTemplate.boundListOps("read" + userId);
        //未读
        List<Object> object = myUnread.range(0, myUnread.size());
        List<Message> unReadMessage = JSONObject.parseArray(JSON.toJSONString(object), Message.class);
        //已读
        List<Object> objects = myRead.range(0, myRead.size());
        List<Message> readMessage = JSONObject.parseArray(JSON.toJSONString(objects), Message.class);
        List<Message> messageList = new ArrayList();
        messageList.addAll(unReadMessage);
        messageList.addAll(readMessage);

        List<Message> arrays = messageList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()
                -> new TreeSet<>(Comparator.comparing(Message::getComeFrom))), ArrayList::new));

        for (Message array : arrays) {
            Long comeFrom = array.getComeFrom();
            if (!ObjectUtil.contains(comFormList, comeFrom)) {
                comFormList.add(comeFrom);
            }

        }
        // 返回数据给前端
        List<ChatVO> userInfoVOList = new ArrayList<>();
        return ResponseMap.success(userInfoVOList);
    }
}
