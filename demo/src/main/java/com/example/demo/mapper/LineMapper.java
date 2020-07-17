package com.example.demo.mapper;

import com.example.demo.entity.Line;
import java.util.List;

public interface LineMapper {
    int deleteByPrimaryKey(Integer lineId);

    int insert(Line record);

    Line selectByPrimaryKey(Integer lineId);

    List<Line> selectAll();

    int updateByPrimaryKey(Line record);

    //获取所有起始站
    List<String> getAllStartPlace();

    //获取所有终点站
    List<String> getAllEndPlace();

    //多条件查询
    List<Line> selectLineByMore(Line record);
}