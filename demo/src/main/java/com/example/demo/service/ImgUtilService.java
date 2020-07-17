package com.example.demo.service;

public interface ImgUtilService {
    //将上传的文件保存到项目内
    String saveImg(String filePath);

    //删除被替换的图片
    void deleteImg(String fileName);

    //获取图片路径
    String getImgPath(String fileName);
}
