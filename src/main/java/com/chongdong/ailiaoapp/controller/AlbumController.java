package com.chongdong.ailiaoapp.controller;

import com.chongdong.ailiaoapp.model.Album;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.AlbumService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Resource
    AlbumService albumService;
    /**
     * 添加相册
     */
    @PostMapping
    public ResponseMap addAlbum(@RequestBody Album album) {
        return albumService.addAlbum(album);
    }

    /**
     * 更新相册(用户修改相册名称，女性用户改变相册开放状态，系统管理修改相册审核/冻结状态
     */
    @PutMapping
    public ResponseMap updateAlbum(@RequestBody Album album) {
        return albumService.updateAlbum(album);
    }

    /**
     * 根据相册编号删除相册
     */
    @DeleteMapping("/{id}")
    public ResponseMap deleteAlbum(@PathVariable Long id) {
        return albumService.deleteAlbum(id);
    }
    /**
     * 获取用户开放相册列表(带首张图片
     * */
    @GetMapping("/public/{userId}")
    public ResponseMap getUserPublicAlbumList(@PathVariable Long userId) {
        return albumService.getUserPublicAlbumList(userId);
    }
    /**
     * 获取用户隐私相册列表(带首张图片
     * */
    @GetMapping("/private/{userId}")
    public ResponseMap getUserPrivateAlbumList(@PathVariable Long userId) {
        return albumService.getUserPrivateAlbumList(userId);
    }
}