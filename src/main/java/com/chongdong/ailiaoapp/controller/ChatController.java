package com.chongdong.ailiaoapp.controller;

import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.ChatService;
import com.chongdong.ailiaoapp.service.MessageService;
import jakarta.annotation.Resource;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("chat")
public class ChatController {
    @Resource
    private MessageService messageService;
    @Resource
    private ChatService chatService;
    @GetMapping
    public ResponseMap listChatAndMessages(@PathParam("userId") Long userId){
        return chatService.listChatAndMessages(userId);
    }
}
