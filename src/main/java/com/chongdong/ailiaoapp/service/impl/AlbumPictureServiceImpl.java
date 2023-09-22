package com.chongdong.ailiaoapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chongdong.ailiaoapp.model.AlbumPicture;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.service.AlbumPictureService;
import com.chongdong.ailiaoapp.mapper.AlbumPictureMapper;
import com.chongdong.ailiaoapp.utils.ResponseMapUtil;
import com.chongdong.ailiaoapp.utils.WrapperUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
* @author cd
* @description 针对表【tcd_album_picture(相册图片)】的数据库操作Service实现
* @createDate 2023-09-22 11:00:25
*/
@Service
public class AlbumPictureServiceImpl extends ServiceImpl<AlbumPictureMapper, AlbumPicture>
    implements AlbumPictureService{
    @Resource
    ResponseMapUtil<AlbumPicture> responseMapUtil;
    @Resource
    WrapperUtil<AlbumPicture> wrapperUtil;

    /**
     * 添加相册图片
     * */
    @Override
    public ResponseMap addAlbumPicture(AlbumPicture albumPicture) {
        albumPicture.setCreateTime(new Date());
        return responseMapUtil.addEntity(this.save(albumPicture));
    }
    /**
     * 删除相册图片同时删除服务器上图片
     * */
    @Override
    @Transactional
    public ResponseMap deleteAlbumPicture(Long id) {
        AlbumPicture albumPicture = this.getById(id);
        File file = new File("."+albumPicture.getPath());
        boolean flag = false;
        if(file.isFile()&&file.exists()){
            flag = file.delete();
        }
        return responseMapUtil.deleteEntity(this.removeById(id) && flag);
    }
    /**
     * 多相册图片删除
     * */
    @Override
    @Transactional
    public ResponseMap deleteAlbumPictureList(List<AlbumPicture> albumPictures) {
        for (AlbumPicture albumPicture:albumPictures){
            File file = new File("."+albumPicture.getPath());
            if(file.isFile()&&file.exists()){
                file.delete();
            }
        }
        return responseMapUtil.deleteList(this.removeBatchByIds(albumPictures));
    }
    /**
     * 根据相册编号获取相册图片
     * */
    @Override
    public ResponseMap getAlbumPicture(Long albumId) {
        List<AlbumPicture> albumPictureList = this.list(wrapperUtil.wrapperAlbumId(albumId));
        return responseMapUtil.getList(albumPictureList);
    }
    /**
     * 根据相册编号删除相册
     * */
    @Override
    @Transactional
    public boolean deleteAlbumPictureWithAlbumId(Long albumId) {
        List<AlbumPicture> list = this.list(wrapperUtil.wrapperAlbumId(albumId));
        for (AlbumPicture albumPicture:list){
            File file = new File("."+albumPicture.getPath());
            if(file.isFile()&&file.exists()){
                file.delete();
            }
        }
        return this.remove(wrapperUtil.wrapperAlbumId(albumId));
    }

    /**
     * 获取相册最后添加的六张图片
     */
    @Override
    public AlbumPicture firstAlbumPicture(Long albumId) {
        if (this.list(wrapperUtil.wrapperAlbumId(albumId)).size()!=0){
            return this.list(wrapperUtil.wrapperAlbumId(albumId)).get(0);
        }else {
            return null;
        }
    }
    /**
     * 根据相册编号统计相册图片数量
     * */
    @Override
    public ResponseMap countAlbumPicture(Long albumId) {
        return responseMapUtil.countNumber((int)this.count(wrapperUtil.wrapperAlbumId(albumId)));
    }
}




