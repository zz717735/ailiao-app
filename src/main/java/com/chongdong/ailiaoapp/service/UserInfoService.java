package com.chongdong.ailiaoapp.service;

import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.model.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author cd
* @description 针对表【tcd_user_info】的数据库操作Service
* @createDate 2023-09-22 16:07:00
*/
public interface UserInfoService extends IService<UserInfo> {

    ResponseMap recommend(Integer gender);

    ResponseMap nearby(Integer gender, String region);
}
