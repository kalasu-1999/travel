package com.example.demo.service.impl;

import com.example.demo.entity.ImgInfo;
import com.example.demo.service.ImgUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;

@Service
public class ImgUtilServiceImpl implements ImgUtilService {
    @Autowired
    Environment environment;
    @Autowired
    private ImgInfo imgInfo;

    //    static {
//        ResourceBundle rb = ResourceBundle.getBundle("application.properties");
//        path = rb.getString("path");
//        url = rb.getString("url");
//    }
    //将上传的文件保存到项目内
    @Override
    public String saveImg(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            System.out.println("file null");
            return null;
        }
        FileOutputStream fos;
        try {
            String fileName = file.getOriginalFilename();
            System.out.println("fileName:" + fileName);
            if (fileName != null) {
                String[] strings = fileName.split("\\.");
                long l = System.currentTimeMillis();
                String outputFileName = l + "." + strings[strings.length - 1];
                String path = URLDecoder.decode(imgInfo.getPath(), "utf8");
                String outputPath = path + outputFileName;
                fos = new FileOutputStream(outputPath);
                System.out.println("outputPath:" + outputPath);
                fos.write(file.getBytes());
//                File outFile = new File(outputPath);
//                file.transferTo(outFile);
                return outputFileName;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
//        return null;
    }

//    @Override
//    public String saveImg(Map<String, Object> file) {
//        if (file == null || file.isEmpty()) {
//            System.out.println("null");
//            return null;
//        }
//        FileOutputStream fos;
//        try {
//            System.out.println(file);
//            String name = (String) file.get("name");
//            System.out.println(name);
//            String path = System.getProperty("user.dir") + "/demo/src/main/resources/static/imgs/";
//            String[] strings = name.split("\\.");
//            long l = System.currentTimeMillis();
//            String outputFileName = l + "." + strings[strings.length - 1];
//            path = URLDecoder.decode(path, "utf8");
//            String outputPath = path + outputFileName;
//            Base64.Decoder urlDecoder = Base64.getUrlDecoder();
//            byte[] bytes = urlDecoder.decode((byte[]) file.get("url"));
//            fos = new FileOutputStream(outputPath);
//            fos.write(bytes);
//            return outputFileName;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    //删除被替换的图片
    @Override
    public void deleteImg(String fileName) {
        File file;
        String filePath = System.getProperty("user.dir") + imgInfo.getUrl() + fileName;
        file = new File(filePath);
        System.out.println(filePath);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("文件删除成功");
            }
        }
    }

    //获取图片路径
    @Override
    public String getImgPath(String fileName) {
        return imgInfo.getUrl() + fileName;
    }
}
