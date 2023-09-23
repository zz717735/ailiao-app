package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.*;
import com.chongdong.ailiaoapp.service.GiftReceiveService;
import com.chongdong.ailiaoapp.mapper.GiftReceiveMapper;
import com.chongdong.ailiaoapp.service.GiftService;
import com.chongdong.ailiaoapp.service.UserInfoService;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author cd
 * @description 针对表【tcd_gift_receive(礼物接收表)】的数据库操作Service实现
 * @createDate 2023-09-22 11:01:52
 */
@Service
public class GiftReceiveServiceImpl extends ServiceImpl<GiftReceiveMapper, GiftReceive>
        implements GiftReceiveService {
    @Resource
    ResponseMapUtil<GiftReceive> responseMapUtil;
    @Resource
    ResponseMapUtil<GiftReceiveVo> voResponseMapUtil;
    @Resource
    ResponseMapUtil<MyGiftVo> myGiftVoResponseMapUtil;
    @Resource
    private GiftService giftService;
    @Resource
    private UserInfoService userInfoService;

    @Override
    public ResponseMap add(GiftReceive giftReceive) {
        giftReceive.setCreateTime(LocalDateTime.now());
        Gift gift = giftService.getById(giftReceive.getGiftId());
        giftReceive.setGiftPrice(gift.getPrice());
        return responseMapUtil.addEntity(this.save(giftReceive));
    }

    @Override
    public ResponseMap myGift(Long receiver) {
        QueryWrapper<GiftReceive> wrapper = new QueryWrapper<>();
        wrapper.select("gift_id", "count(*) as gift_count")
                .groupBy("gift_id")
                .eq("receiver", receiver);
        List<Map<String, Object>> maps = this.baseMapper.selectMaps(wrapper);
        List<MyGiftVo> myGiftVos = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            MyGiftVo myGiftVo = new MyGiftVo();
            Integer gift_id = Integer.valueOf(String.valueOf(map.get("gift_id")));
            Integer gift_count = Integer.valueOf(String.valueOf(map.get("gift_count")));
            Gift gift = giftService.getById(gift_id);
            myGiftVo.setGiftPath(gift.getPath());
            myGiftVo.setPrice(gift.getPrice());
            myGiftVo.setGiftId(gift_id);
            myGiftVo.setAmount(gift_count);
            myGiftVos.add(myGiftVo);
        }
        Collections.sort(myGiftVos, (Comparator.comparing(MyGiftVo::getPrice).reversed()));
        return myGiftVoResponseMapUtil.getList(myGiftVos);
    }

    @Override
    public ResponseMap giftRanking(String date) {
        QueryWrapper<GiftReceive> wrapper = new QueryWrapper<>();
        wrapper.select("receiver", "count(*) as gift_count", "sum(gift_price) as total_price")
                .groupBy("receiver")
                .like("create_time", date);
        List<Map<String, Object>> maps = this.baseMapper.selectMaps(wrapper);
        List<GiftReceiveVo> giftReceiveVos = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            GiftReceiveVo giftReceiveVo = new GiftReceiveVo();
            Long receiver = Long.valueOf(String.valueOf(map.get("receiver")));
            UserInfo userInfo = userInfoService.getById(receiver);
            Integer gift_count = Integer.valueOf(String.valueOf(map.get("gift_count")));
            Double total_price = Double.valueOf(String.valueOf(map.get("total_price")));
            giftReceiveVo.setPrice(total_price);
            giftReceiveVo.setNickname(userInfo.getNickname());
            giftReceiveVo.setReceiver(receiver);
            giftReceiveVo.setAmount(gift_count);
            giftReceiveVo.setAvatar(userInfo.getHeadPath());
            giftReceiveVos.add(giftReceiveVo);
        }
        Collections.sort(giftReceiveVos, (Comparator.comparing(GiftReceiveVo::getPrice).reversed()));
        return voResponseMapUtil.getList(giftReceiveVos);
    }
}




