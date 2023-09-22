package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.Album;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.AlbumPictureService;
import com.chongdong.ailiaoapp.service.AlbumService;
import com.chongdong.ailiaoapp.mapper.AlbumMapper;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import com.chongdong.ailiaoapp.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
* @author cd
* @description 针对表【tcd_album(相册)】的数据库操作Service实现
* @createDate 2023-09-22 11:00:25
*/
@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album>
    implements AlbumService{
    @Resource
    ResponseMapUtil<Album> responseMapUtil;
    @Resource
    WrapperUtil<Album> wrapperUtil;
    @Resource
    AlbumPictureService albumPictureService;
    /**
     * 添加相册
     * */
    @Override
    public ResponseMap addAlbum(Album album) {
        album.setCreateTime(new Date());
        album.setCapacity(21);
        album.setStatus(0);
        return responseMapUtil.addEntity(this.save(album));
    }
    /**
     * 更新相册(用户修改相册名称，女性用户改变相册开放状态，系统管理修改相册冻结状态
     * */
    @Override
    public ResponseMap updateAlbum(Album album) {
        album.setStatus(0);
        return responseMapUtil.updateEntity(this.updateById(album));
    }
    /**
     * 根据相册编号删除相册
     * */
    @Override
    public ResponseMap deleteAlbum(Long id) {
        return responseMapUtil.deleteEntity(this.deleteAlbumWithPicture(id));
    }
    /**
     * 删除相册同时删除图片工具方法
     * */
    @Transactional
    Boolean deleteAlbumWithPicture(Long id){
        return this.removeById(id) && albumPictureService.deleteAlbumPictureWithAlbumId(id);
    }
    /**
     * 获取用户开放相册列表(带首张图片
     * */
    @Override
    public ResponseMap getUserPublicAlbumList(Long userId) {
        List<Album> albumList = this.list(wrapperUtil.wrapperUserOpennessAlbum(userId));
        return responseMapUtil.getList(this.getAlbumFirstPicture(albumList));
    }
    /**
     * 获取用户隐私相册列表(带首张图片
     * */
    @Override
    public ResponseMap getUserPrivateAlbumList(Long userId) {
        List<Album> albumList = this.list(wrapperUtil.wrapperUserPrivateAlbum(userId));
        return responseMapUtil.getList(this.getAlbumFirstPicture(albumList));
    }
    /**
     * 获取用户首张图片工具方法
     * */
    private List<Album> getAlbumFirstPicture(List<Album> albumList){
        for (Album album : albumList) {
            album.setFirstAlbumPicture(albumPictureService.firstAlbumPicture(album.getId()));
        }
        return albumList;
    }

}




