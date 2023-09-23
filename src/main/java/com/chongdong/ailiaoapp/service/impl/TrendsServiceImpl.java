package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.mapper.TrendsLikeMapper;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.model.Trends;
import com.chongdong.ailiaoapp.model.TrendsLike;
import com.chongdong.ailiaoapp.service.TrendsService;
import com.chongdong.ailiaoapp.mapper.TrendsMapper;
import com.chongdong.ailiaoapp.utils.ImageUtil;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import com.chongdong.ailiaoapp.utils.SensitivewordUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author cd
* @description 针对表【tcd_trends(用户动态表)】的数据库操作Service实现
* @createDate 2023-09-22 10:53:04
*/
@Service
public class TrendsServiceImpl extends ServiceImpl<TrendsMapper, Trends>
    implements TrendsService{
    @Resource
    ResponseMapUtil<Trends> responseMapUtil;
    @Resource
    TrendsMapper trendsMapper;
    @Resource
    TrendsLikeMapper trendsLikeMapper;

    //删除单个动态
    @Override
    public ResponseMap deleteTrends(Long id) {
        QueryWrapper<TrendsLike> wrapper=new QueryWrapper<>();
        wrapper.eq("trends_id",id);
        trendsLikeMapper.delete(wrapper);
        return responseMapUtil.deleteEntity(removeById(id));
    }

    //获取单个动态
    @Override
    public ResponseMap selectOneTrends(Long id) {
        return responseMapUtil.getEntity(getById(id));
    }

    //查询个人全部动态
    @Override
    public ResponseMap AllQueryTrends(Long userid) {
        List<Trends> trendsList = trendsMapper.selectList(new QueryWrapper<Trends>().eq("userid", userid));
        return responseMapUtil.getList(trendsList);
    }

    //添加或修改动态
    @Override
    public ResponseMap addOrEdit(Trends trends) {
        if (trends.getId()!=null){
            //进行修改
            Trends trends1 = trendsMapper.selectOne(new QueryWrapper<Trends>().eq("id", trends.getId()));
            trends.setId(trends1.getId());
            trends.setCreatetime(trends1.getCreatetime());
            trends.setEdittime(new Date());
            trends.setImgsrc(trends.getImagesArray().toString());
            String content = trends.getContent();
            //进行内容过滤,最小匹配规则
            content = SensitivewordUtil.replaceSensitiveWord(content, 1, "*");
            trends.setContent(content);
            //设置文章图片
            List<String> imgStr = ImageUtil.getImgStr(content);
            if (imgStr.size() == 0){
                trends.setImgsrc("/images/white.jpg");
            }else {
                //取第一张图片即可
                String src = imgStr.get(0);
                trends.setImgsrc(src);
            }
            return responseMapUtil.updateOrAddEntity(trendsMapper.updateById(trends));
        }else {
            //是添加
            String content = trends.getContent();
            trends.setImgsrc(trends.getImagesArray().toString());
            //进行内容和标题过滤
            content=SensitivewordUtil.replaceSensitiveWord(content,1,"*");
            trends.setContent(content);
            List<String> imgStr = ImageUtil.getImgStr(content);
            if (imgStr.size() == 0){
                String src = trends.getImagesArray().toString();
                trends.setImgsrc(src);
            }
            trends.setCreatetime(new Date());
            trends.setUserid(trends.getUserid());
            trends.setCount(0L);
            trends.setStatus(1);//动态待审核
            return responseMapUtil.updateOrAddEntity(trendsMapper.insert(trends));
        }
    }
}




