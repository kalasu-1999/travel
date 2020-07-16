package com.example.demo.mapper;

import com.example.demo.entity.News;
import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    News selectByPrimaryKey(Integer newsId);

    List<News> selectAll();

    int updateByPrimaryKey(News record);

    //根据新闻id修改标识
    int updateFlagByNewsId(Integer newsId);

    //根据输入信息对新闻进行模糊查询
    List<News> selectNewsByHint(String hint);
}