package com.example.demo.service;

import com.example.demo.entity.Line;

import java.math.BigDecimal;
import java.util.List;

public interface LineService {
    //添加路线
    int insertLine(String lineLevel, String lineName, String lineType, String startPlace, String endPlace, Integer day, BigDecimal price1, BigDecimal price2, Integer qp, Integer dp, String meetPlace, String meetPhone, String goTransport, String backTransport, String lineImage, String linePhone, Integer status, String djs, String bak, String weblog);

    //获取所有起始站
    List<String> getAllStartPlace();

    //获取所有终点站
    List<String> getAllEndPlace();

    //获取所有线路
    List<Line> getAllLine();

    //根据起始站获取所有线路
    List<Line> getLineByStartPlace(String startPlace);

    //根据终点站获取所有路线
    List<Line> getLineByEndPlace(String endPlace);

    //根据起始站和终点站获取所有路线
    List<Line> getLineByStartPlaceAndEndPlace(String startPlace, String endPlace);

    //根据路线id获取路线
    Line getLineByLineId(Integer lineId);

    //根据路线id路线信息修改
    int updateLineByLineId(Integer lineId, String lineLevel, String lineName, String lineType, String startPlace, String endPlace, Integer day, BigDecimal price1, BigDecimal price2, Integer qp, Integer dp, String meetPlace, String meetPhone, String goTransport, String backTransport, String lineImage, String linePhone, Integer status, String djs, String bak, String weblog);

    //根据路线名称获取路线
    Line getLineByLineName(String lineName);
}
