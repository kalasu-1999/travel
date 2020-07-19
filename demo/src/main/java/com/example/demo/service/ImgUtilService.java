package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImgUtilService {
    //将上传的文件保存到项目内
    String saveImg(MultipartFile file);

    //删除被替换的图片
    void deleteImg(String fileName);

    //获取图片路径
    String getImgPath(String fileName);
}
