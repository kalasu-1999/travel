package com.example.demo.service;

import com.example.demo.entity.News;

import java.util.List;

public interface NewsService {
    //显示所有新闻按时间排序
    List<News> selectAllNews();

    //添加新闻
    int insertNews(String title, String show);

    //根据新闻id修改新闻标识
    int updateNewsByNewsId(Integer newsId);

    //根据标题信息模糊查询
    List<News> selectNewsByHint(String hint);
}
