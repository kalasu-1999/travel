package com.example.demo.mapper;

import com.example.demo.entity.LineViews;
import java.util.List;

public interface LineViewsMapper {
    int deleteByPrimaryKey(Integer lineviewsId);

    int insert(LineViews record);

    LineViews selectByPrimaryKey(Integer lineviewsId);

    List<LineViews> selectAll();

    int updateByPrimaryKey(LineViews record);

    //根据指定的景点id获取全部线路id
    List<Integer> selectAllLine(Integer viewId);

    //根据指定的线路id获取全部景点id
    List<Integer> selectAllView(Integer lineId);
}