package com.chongdong.ailiaoapp.controller;

import com.chongdong.ailiaoapp.model.Gift;
import com.chongdong.ailiaoapp.model.GiftReceive;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.GiftReceiveService;
import com.chongdong.ailiaoapp.service.GiftService;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/gifts")
@Slf4j
public class GiftController {
    @Resource
    private GiftService giftService;
    @Resource
    private GiftReceiveService giftReceiveService;


    /**
     * 礼物遍历
     * @return
     */
    @GetMapping("/list")
    public ResponseMap query(){
        return giftService.queryList();
    }

    /**
     * 赠送礼物
     * @param giftReceive
     * @return
     */
    @PostMapping("/add")
    public ResponseMap add(@RequestBody GiftReceive giftReceive){
        return giftReceiveService.add(giftReceive);
    }

    /**
     * 我的礼物
     * @param receiver
     * @return
     */
    @GetMapping("/myGift")
    public ResponseMap myGift(@RequestParam Long receiver){
        return giftReceiveService.myGift(receiver);
    }

    /**
     * 礼物榜单
     * @param date
     * @return
     */
    @GetMapping("/giftRanking")
    public ResponseMap giftRanking(@RequestParam @DateTimeFormat(pattern = "yyyy-MM") String date){
        return giftReceiveService.giftRanking(date);
    }

    /**
     * 根据id发送的礼物信息和用户信息
     * @param giftId
     * @return
     */
    @GetMapping("/queryOne")
    public ResponseMap queryOne(@RequestParam Integer giftId,@RequestParam Long userId){
        return giftService.queryOne(giftId,userId);
    }
}