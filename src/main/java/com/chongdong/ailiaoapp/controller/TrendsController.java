package com.chongdong.ailiaoapp.controller;


import com.chongdong.ailiaoapp.factory.EntityFactory;
import com.chongdong.ailiaoapp.model.AlbumPicture;
import com.chongdong.ailiaoapp.model.ResponseMap;
import com.chongdong.ailiaoapp.model.Trends;
import com.chongdong.ailiaoapp.model.TrendsLike;
import com.chongdong.ailiaoapp.service.TrendsLikeService;
import com.chongdong.ailiaoapp.service.TrendsService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping("Trends")
public class TrendsController {
    @Resource
    TrendsService trendsService;
    @Resource
    TrendsLikeService trendsLikeService;


    //动态单个删除
    @DeleteMapping("/trendsDelete/{id}")
    @ResponseBody
    public ResponseMap trendsDelete(@PathVariable("id") Long id){
        return trendsService.deleteTrends(id);
    }

    //查询用户单个动态
    @GetMapping("/getOne/{id}")
    @ResponseBody
    public ResponseMap selectOneTrends(@PathVariable Long id){
        return trendsService.selectOneTrends(id);
    }

    //查询个人全部动态
    @GetMapping("/getList/{userid}")
    @ResponseBody
    public ResponseMap allQueryTrends(@PathVariable("userid") Long userid){
        return trendsService.AllQueryTrends(userid);
    }

    //动态保存
    @PostMapping("addOrEdit")
    @ResponseBody
    public ResponseMap trendsSave(@RequestBody Trends trends) {
        return trendsService.addOrEdit(trends);
    }

    //动态点赞（一个用户只能点赞一个动态一次）
    @PostMapping("like")
    @ResponseBody
    public ResponseMap LikeTrends(@RequestBody TrendsLike trendsLike){
        return trendsLikeService.likeTrends(trendsLike);
    }

    //动态图片上传
    @PostMapping(value = "/upload")
    //@RequestParam指向前端input file的name,加入HttpServletRequest请求
    public Map<String,Object> upload(@RequestParam("file") MultipartFile[] multipartFiles, HttpServletRequest request) throws IOException {
        //设置当前日期
        //String uploaddate= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        //设置文件上传保存文件路径：保存在项目运行目录下的uploadFile文件夹+当前日期
        String savepath = "./images/";
        //创建文件夹,当文件夹不存在时，创建文件夹
        File folder = new File(savepath);
        if(!folder.isDirectory()){
            folder.mkdir();
        }
        String realPath = folder.getCanonicalPath();
        //建立一个listmap的返回参数
        Map<String,Object> map=new HashMap<>();
        List<String> fileNames=new ArrayList<>();
        //建立一个循环分别接收多文件
        for(MultipartFile file:multipartFiles){
            //重命名上传的文件,为避免重复,我们使用UUID对文件分别进行命名
            String oldname=file.getOriginalFilename();//getOriginalFilename()获取文件名带后缀
            //UUID去掉中间的"-",并将原文件后缀名加入新文件
            String newname= UUID.randomUUID().toString().replace("-","")
                    +oldname.substring(oldname.lastIndexOf("."));
            //建立每一个文件上传的返回参数
            //文件保存操作
            try {
                file.transferTo(new File(realPath+"/"+newname));
                //建立新文件路径,在前端可以直接访问如http://localhost:8080/uploadFile/2021-07-16/新文件名(带后缀)
                String filepath="http://192.168.0.113:8089/images/"+newname;
                //写入返回参数
                fileNames.add(filepath);
                map.put("filepath",fileNames);
                map.put("result", "动态图片上传成功！！！");
            }catch (IOException ex){
                //操作失败报错并写入返回参数
                ex.printStackTrace();
                map.put("filepath","");
                map.put("result","上传失败!");
            }
        }

        //将执行结果返回
        return map;
    }






}
