package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.mapper.AlbumMapper;
import com.chongdong.ailiaoapp.mapper.AlbumPictureMapper;
import com.chongdong.ailiaoapp.mapper.VisitorMapper;
import com.chongdong.ailiaoapp.model.*;
import com.chongdong.ailiaoapp.service.UserInfoService;
import com.chongdong.ailiaoapp.mapper.UserInfoMapper;
import com.chongdong.ailiaoapp.service.VisitorService;
import com.chongdong.ailiaoapp.utils.Distance;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.FloatBuffer;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
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
    @Resource
    private ResponseMap responseMap;
    @Resource
    private VisitorService visitorService;
    @Resource
    private VisitorMapper visitorMapper;
    @Resource
    private UserInfoMapper userInfoMapper;

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

    @Override
    public ResponseMap queryById(Long infoId,Long respondentsId) {
        //respondentsId被访者
        //infoId是指访者，登录人
        //查询出被访问者的信息
        UserInfo userInfo = userInfoMapper.queryById(respondentsId);
        //通过被访问者查出访问者信息，如果有访问者那么就修改时间如果没有访问者那么就添加一个该访问者。
        QueryWrapper<Visitor> wrapper = new QueryWrapper<>();
        wrapper.eq("respondents_id",respondentsId);
        List<Visitor> visitors = visitorMapper.selectList(wrapper);
        //遍历查询出所有
        for (Visitor visitor : visitors) {
            //如果登录人id和访客id相同那就修改访客时间，如果登录人id和访客id不相同那么就添加时间
            if(visitor.getVisitorId()==infoId){
                //修改时间
                visitor.setCreateTime(LocalDateTime.now());
                visitorService.updateById(visitor);
                break;
            }else {
                //添加访客
                Visitor vis=new Visitor();
                vis.setVisitorId(infoId);
                vis.setRespondentsId(respondentsId);
                vis.setCreateTime(LocalDateTime.now());
                visitorService.save(vis);
                break;
            }
        }
        return responseMapUtil.getEntity(userInfo);
    }
}




