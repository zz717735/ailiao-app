package com.chongdong.ailiaoapp.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatVO {
    private Long userId;
    private String nickname;
    private String headPath;
    private LocalDateTime createTime;
    private String message;
    private Integer numberOfMessages;
}
