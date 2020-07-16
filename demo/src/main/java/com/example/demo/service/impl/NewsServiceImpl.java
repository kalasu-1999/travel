package com.example.demo.service.impl;

import com.example.demo.entity.News;
import com.example.demo.mapper.NewsMapper;
import com.example.demo.service.NewsService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public Page<News> selectAllNews() {
        return (Page<News>) newsMapper.selectAll();
    }

    @Override
    public int insertNews(String title, String show) {
        Date date = new Date(System.currentTimeMillis());
        return newsMapper.insert(new News(null,title,show,date,"0"));
    }

    @Override
    public int updateNewsByNewsId(Integer newsId) {
        return newsMapper.updateFlagByNewsId(newsId);
    }

    @Override
    public Page<News> selectNewsByHint(String hint) {
        return (Page<News>) newsMapper.selectNewsByHint(hint);
    }
}
