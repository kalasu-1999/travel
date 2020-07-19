package com.example.demo.service;

import com.example.demo.entity.Views;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface ViewsService {
    //添加景点
    int insertViews(String viewName, MultipartFile file, String content);

    //修改景点信息
    int updateViews(Integer viewId, String viewName, MultipartFile file, String content);

    //根据景点id获取景点信息
    Views selectViewsByViewId(Integer viewId);

    //根据hint进行模糊查询
    List<Views> selectViewsByHint(String hint);

    //显示全部景点
    List<Views> selectAllViews();

    //根据景点id进行景点删除
    int deleteViewsByViewId(Integer viewId);

}
