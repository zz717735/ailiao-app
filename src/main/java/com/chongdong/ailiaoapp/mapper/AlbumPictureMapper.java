package com.chongdong.ailiaoapp.mapper;

import com.chongdong.ailiaoapp.model.AlbumPicture;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_album_picture(相册图片)】的数据库操作Mapper
* @createDate 2023-09-22 11:00:25
* @Entity com.chongdong.ailiaoapp.model.AlbumPicture
*/
public interface AlbumPictureMapper extends BaseMapper<AlbumPicture> {
    List<AlbumPicture> queryAll(Long albumId);
}




