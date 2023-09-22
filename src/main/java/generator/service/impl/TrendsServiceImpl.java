package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.model.Trends;
import generator.service.TrendsService;
import generator.mapper.TrendsMapper;
import org.springframework.stereotype.Service;

/**
* @author cd
* @description 针对表【tcd_trends(用户动态表)】的数据库操作Service实现
* @createDate 2023-09-22 10:50:22
*/
@Service
public class TrendsServiceImpl extends ServiceImpl<TrendsMapper, Trends>
    implements TrendsService{

}




