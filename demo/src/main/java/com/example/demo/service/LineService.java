package com.example.demo.service;

import com.example.demo.entity.Line;

import java.math.BigDecimal;
import java.util.List;

public interface LineService {
    //添加路线
    int insertLine(String lineLevel, String lineName, String lineType, String startPlace, String endPlace, Integer day, BigDecimal price1, BigDecimal price2, Integer qp, Integer dp, String meetPlace, String meetPhone, String goTransport, String backTransport, String lineImage, String linePhone, String djs, String bak, String weblog);

    //获取所有起始站
    List<String> getAllStartPlace();

    //获取所有终点站
    List<String> getAllEndPlace();

    //获取所有线路
    List<Line> getAllLine();

    //多条件查询
    List<Line> getLineByMore(Integer lineId, String lineLevel, String lineName, String lineType, String startPlace, String endPlace, Integer day, BigDecimal price1, BigDecimal price2, Integer qp, Integer dp, String meetPlace, String meetPhone, String goTransport, String backTransport, String linePhone, String djs, String bak, String weblog);

    //根据路线id路线信息修改
    int updateLineByLineId(Integer lineId, String lineLevel, String lineName, String lineType, String startPlace, String endPlace, Integer day, BigDecimal price1, BigDecimal price2, Integer qp, Integer dp, String meetPlace, String meetPhone, String goTransport, String backTransport, String lineImage, String linePhone, String djs, String bak, String weblog);

    //根据id获取路线
    Line selectLineByLineId(Integer lineId);

    //修改线路是否停运（默认0表示运行，1停运）
    int updateLineState(Integer lineId, Integer state);
}
