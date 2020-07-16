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

    //根据起始站获取所有线路
    List<Line> getLineByStartPlace(String startPlace);

    //根据终点站获取所有路线
    List<Line> getLineByEndPlace(String endPlace);

    //根据起始站和终点站获取所有路线
    List<Line> getLineByStartPlaceAndEndPlace(String startPlace, String endPlace);

    //根据线路名称获取线路
    Line selectLineByLineName(String lineName);
}