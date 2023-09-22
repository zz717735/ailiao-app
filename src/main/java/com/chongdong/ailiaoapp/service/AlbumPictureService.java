package com.chongdong.ailiaoapp.service;

import com.chongdong.ailiaoapp.model.AlbumPicture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.ailiaoapp.model.ResponseMap;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_album_picture(相册图片)】的数据库操作Service
* @createDate 2023-09-22 11:00:25
*/
public interface AlbumPictureService extends IService<AlbumPicture> {
    /**
     * 添加相册图片
     * */
    ResponseMap addAlbumPicture(AlbumPicture albumPicture);
    /**
     * 删除相册图片同时删除服务器上图片
     * */
    ResponseMap deleteAlbumPicture(Long id);
    /**
     * 多相册图片删除
     * */
    ResponseMap deleteAlbumPictureList(List<AlbumPicture> albumPictures);
    /**
     * 根据相册编号获取相册图片
     * */
    ResponseMap getAlbumPicture(Long albumId);
    /**
     * 根据相册编号删除相册
     * */
    boolean deleteAlbumPictureWithAlbumId(Long albumId);
    /**
     * 获取相册首张图片工具方法
     * */
    AlbumPicture firstAlbumPicture(Long albumId);

    /**
     * 根据相册编号统计相册图片数量
     * */
    ResponseMap countAlbumPicture(Long albumId);
}
