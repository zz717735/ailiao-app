package com.chongdong.ailiaoapp.controller;

import com.chongdong.ailiaoapp.model.Gift;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.model.UserInfo;
import com.chongdong.ailiaoapp.service.UserInfoService;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private ResponseMapUtil<UserInfo> responseMapUtil;

    /**
     * 测试
     * @return
     */
    @GetMapping("/list")
    public ResponseMap list(){
        return responseMapUtil.getList(userInfoService.list());
    }

    /**
     * 首页推荐
     * @param gender
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/recommend")
    public ResponseMap recommend(
            @RequestParam Integer gender,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size
            ){
        return userInfoService.recommend(gender);
    }

    /**
     * 首页附近
     * @param gender
     * @param page
     * @param size
     * @param region
     * @return
     */
    @GetMapping("/nearby")
    public ResponseMap nearby(@RequestParam Integer gender,
                              @RequestParam(required = false) Integer page,
                              @RequestParam(required = false) Integer size,
                              @RequestParam String region){
        return userInfoService.nearby(gender,region);
    }
}
