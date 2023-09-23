package com.chongdong.ailiaoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class GiftReceiveVo {
    private Long receiver;//接收者id
    private String nickname;//赠送者昵称
    private Integer amount;//礼物数量
    private Double price;//礼物总价格
    private String avatar;//头像
}
