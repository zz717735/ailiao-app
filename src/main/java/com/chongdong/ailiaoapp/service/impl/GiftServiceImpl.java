package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.Gift;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.GiftService;
import com.chongdong.ailiaoapp.mapper.GiftMapper;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_gift(礼物表)】的数据库操作Service实现
* @createDate 2023-09-22 11:01:52
*/
@Service
public class GiftServiceImpl extends ServiceImpl<GiftMapper, Gift>
    implements GiftService{

    @Resource
    ResponseMapUtil<Gift> responseMapUtil;
    @Override
    public ResponseMap queryList() {
         List<Gift> list = this.list();
        System.out.println(list);
        return responseMapUtil.getList(list);
    }
}




