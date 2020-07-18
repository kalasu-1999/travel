package com.example.demo.service.impl;

import com.example.demo.entity.News;
import com.example.demo.mapper.NewsMapper;
import com.example.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> selectAllNews() {
        return newsMapper.selectAll();
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
    public List<News> selectNewsByHint(String hint) {
        return newsMapper.selectNewsByHint(hint);
    }
}
