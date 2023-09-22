package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.model.Rule;
import generator.service.RuleService;
import generator.mapper.RuleMapper;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_rule(会员规则表)】的数据库操作Service实现
* @createDate 2023-09-22 10:50:22
*/
@Service
public class RuleServiceImpl extends ServiceImpl<RuleMapper, Rule>
    implements RuleService{

}




