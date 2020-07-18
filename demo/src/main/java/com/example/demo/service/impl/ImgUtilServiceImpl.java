package com.example.demo.service.impl;

import com.example.demo.service.ImgUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.UnknownHostException;

@Service
public class ImgUtilServiceImpl implements ImgUtilService {
    @Autowired
    Environment environment;


    //将上传的文件保存到项目内
    @Override
    public String saveImg(File file) {
        InputStream is;
        OutputStream os;
        try {
            String fileName = file.getName();
            String[] strings = fileName.split("\\.");
            long l = System.currentTimeMillis();
            String outputFileName = l + "." + strings[strings.length - 1];
            String path = System.getProperty("user.dir") + "/demo/src/main/resources/static/imgs/";
            path = URLDecoder.decode(path, "utf8");
            String outputPath = path + outputFileName;
            is = new FileInputStream(file);
            os = new FileOutputStream(new File(outputPath));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            return outputFileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //删除被替换的图片
    @Override
    public void deleteImg(String fileName) {
        File file;
        String filePath = System.getProperty("user.dir") + "/demo/src/main/resources/static/imgs/" + fileName;
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
        InetAddress localHost = null;
        try {
            localHost = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        assert localHost != null;
        return "http://" + localHost.getHostAddress() + ":" + environment.getProperty("local.server.port") + "/static/imgs/" + fileName;
    }
}
