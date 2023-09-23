package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.Gift;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.model.UserGiftVo;
import com.chongdong.ailiaoapp.model.UserInfo;
import com.chongdong.ailiaoapp.service.GiftService;
import com.chongdong.ailiaoapp.mapper.GiftMapper;
import com.chongdong.ailiaoapp.service.UserInfoService;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cd
 * @description 针对表【tcd_gift(礼物表)】的数据库操作Service实现
 * @createDate 2023-09-22 11:01:52
 */
@Service
public class GiftServiceImpl extends ServiceImpl<GiftMapper, Gift>
        implements GiftService {

    @Resource
    private UserInfoService userInfoService;
    @Resource
    ResponseMapUtil<Gift> responseMapUtil;
    @Resource
    ResponseMapUtil<UserGiftVo> userGiftVoResponseMapUtil;

    @Override
    public ResponseMap queryList() {
        List<Gift> list = this.list();
        System.out.println(list);
        return responseMapUtil.getList(list);
    }

    @Override
    public ResponseMap queryOne(Integer giftId, Long userId) {
        Gift gift = this.getById(giftId);
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.select("info_id", "head_path", "nickname")
                .eq("info_id", userId);
        UserInfo userInfo = userInfoService.getOne(wrapper);
        final UserGiftVo userGiftVo = new UserGiftVo();
        userGiftVo.setGift(gift);
        userGiftVo.setUserInfo(userInfo);
        return userGiftVoResponseMapUtil.getEntity(userGiftVo);
    }
}




