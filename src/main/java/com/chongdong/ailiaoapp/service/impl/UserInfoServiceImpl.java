package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.model.UserInfo;
import com.chongdong.ailiaoapp.service.UserInfoService;
import com.chongdong.ailiaoapp.mapper.UserInfoMapper;
import com.chongdong.ailiaoapp.utils.Distance;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cd
 * @description 针对表【tcd_user_info】的数据库操作Service实现
 * @createDate 2023-09-22 16:07:00
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {
    @Resource
    private ResponseMapUtil<UserInfo> responseMapUtil;

    @Override
    public ResponseMap recommend(Integer gender) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.select("info_id", "head_path", "birthday", "region", "nickname", "like_number")
                .notIn("gender", gender)
                .orderByDesc("like_number");
        List<UserInfo> list = this.list(wrapper);
        return responseMapUtil.getList(list);
    }

    @Override
    public ResponseMap nearby(Integer gender, String region) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.select("info_id", "head_path", "birthday", "region", "nickname", "like_number")
                .notIn("gender", gender)
                //.like("region", region)
                .orderByDesc("like_number");
        List<UserInfo> list = this.list(wrapper);
        for (UserInfo userInfo : list) {
            double distance = Distance.getDistance(region, userInfo.getRegion());
            userInfo.setDistance(distance);
        }
        return responseMapUtil.getList(list);
    }
}




