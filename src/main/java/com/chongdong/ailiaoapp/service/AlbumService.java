package com.chongdong.ailiaoapp.service;

import com.chongdong.ailiaoapp.model.Album;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chongdong.ailiaoapp.model.ResponseMap;

import java.util.List;

/**
* @author cd
* @description 针对表【tcd_album(相册)】的数据库操作Service
* @createDate 2023-09-22 11:00:25
*/
public interface AlbumService extends IService<Album> {
    /**
     * 添加相册
     * */
    ResponseMap addAlbum(Album album);
    /**
     * 更新相册(用户修改相册名称，女性用户改变相册开放状态，系统管理修改相册冻结状态
     * */
    ResponseMap updateAlbum(Album album);
    /**
     * 根据相册编号删除相册
     * */
    ResponseMap deleteAlbum(Long id);
    /**
     * 获取用户开放相册列表(带首张图片
     * */
    ResponseMap getUserPublicAlbumList(Long userId);
    /**
     * 获取用户隐私相册列表(带首张图片
     * */
    ResponseMap getUserPrivateAlbumList(Long userId);
}
