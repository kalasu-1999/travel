package com.example.demo.service.impl;

import com.example.demo.service.ImgUtilService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URLDecoder;

@Service
public class ImgUtilServiceImpl implements ImgUtilService {
    //将上传的文件保存到项目内
    @Override
    public String saveImg(String filePath) {
        InputStream is;
        OutputStream os;
        File inputFile;
        try {
            inputFile = new File(filePath);
            String fileName = inputFile.getName();
            String[] strings = fileName.split("\\.");
            long l = System.currentTimeMillis();
            String outputFileName = l + "." + strings[strings.length - 1];
            String path = ImgUtilServiceImpl.class.getResource("/").getPath();
            path = URLDecoder.decode(path, "utf8");
            String outputPath = path + "imgs/" + outputFileName;
            is = new FileInputStream(inputFile);
            os = new FileOutputStream(new File(outputPath));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            return outputPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //删除被替换的图片
    public boolean deleteImg(String fileName) {
        File file;
        try {
            String path = ImgUtilServiceImpl.class.getResource("/").getPath();
            path = URLDecoder.decode(path, "utf8");
            String filePath = path + "imgs/" + fileName;
            file = new File(filePath);
            System.out.println(filePath);
            if (file.exists() && file.isFile()) {
                if (file.delete()) {
                    return true;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
