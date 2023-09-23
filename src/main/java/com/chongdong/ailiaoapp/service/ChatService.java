package com.chongdong.ailiaoapp.service;

import com.chongdong.ailiaoapp.model.ResponseMap;

public interface ChatService {
    ResponseMap listChatAndMessages(Long userId);
}
