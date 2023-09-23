package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.Message;
import com.chongdong.ailiaoapp.service.MessageService;
import com.chongdong.ailiaoapp.mapper.MessageMapper;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【tcd_message(信息表)】的数据库操作Service实现
* @createDate 2023-09-23 14:58:00
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

}




