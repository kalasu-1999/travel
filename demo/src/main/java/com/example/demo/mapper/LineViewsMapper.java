package com.example.demo.mapper;

import com.example.demo.entity.LineViews;
import java.util.List;

public interface LineViewsMapper {
    int deleteByPrimaryKey(Integer lineviewsId);

    int insert(LineViews record);

    LineViews selectByPrimaryKey(Integer lineviewsId);

    List<LineViews> selectAll();

    int updateByPrimaryKey(LineViews record);
}