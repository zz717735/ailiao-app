package com.chongdong.ailiaoapp.mapper;

import com.chongdong.ailiaoapp.model.Album;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_album(相册)】的数据库操作Mapper
* @createDate 2023-09-22 11:00:25
* @Entity com.chongdong.ailiaoapp.model.Album
*/
public interface AlbumMapper extends BaseMapper<Album> {
    List<Album> queryAllList(Long userId);
}




