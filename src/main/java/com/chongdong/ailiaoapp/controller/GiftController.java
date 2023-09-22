package com.chongdong.ailiaoapp.controller;

import com.chongdong.ailiaoapp.service.GiftService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gifts")
@Slf4j
public class GiftController {
    @Resource
    private GiftService giftService;
}
