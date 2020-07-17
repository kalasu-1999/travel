package com.example.demo.service;

import com.example.demo.entity.Views;

import java.util.List;

public interface ViewsService {
    //添加景点
    int insertViews(String viewName, String viewImage, String content);

    //修改景点信息
    int updateViews(Integer viewId, String viewName, String viewImage, String content);

    //根据景点id获取景点信息
    Views selectViewsByViewId(Integer viewId);

    //根据hint进行模糊查询
    List<Views> selectViewsByHint(String hint);

    //显示全部景点
    List<Views> selectAllViews();

    //根据景点id进行景点删除
    int deleteViewsByViewId(Integer viewId);

    //根据景点id和景点名称获取景点
    Views selectViewsByViewIdAndViewName(Integer viewId,String viewName);
}
