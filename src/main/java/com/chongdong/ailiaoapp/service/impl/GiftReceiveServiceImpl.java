package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.Gift;
import com.chongdong.ailiaoapp.model.GiftReceive;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.GiftReceiveService;
import com.chongdong.ailiaoapp.mapper.GiftReceiveMapper;
import com.chongdong.ailiaoapp.service.GiftService;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @author cd
* @description 针对表【tcd_gift_receive(礼物接收表)】的数据库操作Service实现
* @createDate 2023-09-22 11:01:52
*/
@Service
public class GiftReceiveServiceImpl extends ServiceImpl<GiftReceiveMapper, GiftReceive>
    implements GiftReceiveService{
    @Resource
    ResponseMapUtil<GiftReceive> responseMapUtil;
    @Resource
    private GiftService giftService;
    @Override
    public ResponseMap add(GiftReceive giftReceive) {
        giftReceive.setCreateTime(LocalDateTime.now());
         Gift gift = giftService.getById(giftReceive.getGiftId());
        giftReceive.setGiftPrice(gift.getPrice());
        return responseMapUtil.addEntity(this.save(giftReceive));
    }

    @Override
    public ResponseMap myGift(Long receiver, String date) {
        final QueryWrapper<GiftReceive> wrapper = new QueryWrapper<>();
        System.out.println(date);
        wrapper.select("user_id","count(*) as gift_count","sum(gift_price) as total_price")
                .groupBy("user_id")
                .eq("receiver",receiver)
                .like("create_time",date);
        final List<Map<String, Object>> maps = this.baseMapper.selectMaps(wrapper);
        System.out.println(maps);

        return null;
    }
}




