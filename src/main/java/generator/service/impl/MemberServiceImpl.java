package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.model.Member;
import generator.service.MemberService;
import generator.mapper.MemberMapper;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_member(会员等级表)】的数据库操作Service实现
* @createDate 2023-09-22 10:50:22
*/
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member>
    implements MemberService{

}




