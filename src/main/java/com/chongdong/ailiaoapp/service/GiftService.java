package com.chongdong.ailiaoapp.service;

import com.chongdong.ailiaoapp.model.Gift;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;

/**
* @author cd
* @description 针对表【tcd_gift(礼物表)】的数据库操作Service
* @createDate 2023-09-22 11:01:52
*/
public interface GiftService extends IService<Gift> {

    ResponseMap queryList();
}
