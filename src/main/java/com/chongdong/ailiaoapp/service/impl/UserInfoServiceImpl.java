package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.UserInfo;
import com.chongdong.ailiaoapp.service.UserInfoService;
import com.chongdong.ailiaoapp.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_user_info】的数据库操作Service实现
* @createDate 2023-09-22 16:07:00
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




