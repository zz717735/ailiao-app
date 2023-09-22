package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.Member;
import com.chongdong.ailiaoapp.service.MemberService;
import com.chongdong.ailiaoapp.mapper.MemberMapper;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_member(会员等级表)】的数据库操作Service实现
* @createDate 2023-09-22 10:53:04
*/
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member>
    implements MemberService{

}




