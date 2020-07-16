package com.example.demo.controller;

import com.example.demo.service.impl.ImgUtilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/img")
public class ImgController {
    @Autowired
    ImgUtilServiceImpl imgUtilService;


    @RequestMapping("/save")
    public Map<String, Object> saveImg(String filePath) {
        Map<String, Object> map = new HashMap<>();
        String s = imgUtilService.saveImg(filePath);
        map.put("url", s);
        if (s == null) {
            System.out.println("文件上传失败");
            map.put("msg", -1);
        } else {
            map.put("msg", 0);
        }
        return map;
    }

    @RequestMapping("/delete")
    public Map<String, Object> deleteImg() {
        Map<String,Object> map = new HashMap<>();
        map.put("msg",imgUtilService.deleteImg("1594776214980.png"));
        return map;
    }
}
