package com.chongdong.ailiaoapp.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MyGiftVo {
    private Integer giftId;//礼物id
    private Integer amount;//礼物数量
    private BigDecimal price;//礼物价格
    private String giftPath;//礼物图片
}
