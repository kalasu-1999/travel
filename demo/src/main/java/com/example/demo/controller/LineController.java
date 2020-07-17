package com.example.demo.controller;

import com.example.demo.entity.Line;
import com.example.demo.service.LineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/line")
public class LineController {
    @Autowired
    private LineService lineService;

    //添加路线
    @RequestMapping("/insertLine")
    public Map<String, Object> insertLine(String lineLevel, String lineName, String lineType, String startPlace, String endPlace, Integer day, BigDecimal price1, BigDecimal price2, Integer qp, Integer dp, String meetPlace, String meetPhone, String goTransport, String backTransport, String lineImage, String linePhone, Integer status, String djs, String bak, String weblog) {
        Map<String, Object> map = new HashMap<>();
        if (lineService.insertLine(lineLevel, lineName, lineType, startPlace, endPlace, day, price1, price2, qp, dp, meetPlace, meetPhone, goTransport, backTransport, lineImage, linePhone, status, djs, bak, weblog) == 1) {
            map.put("code", 0);
            map.put("msg", "路线添加成功");
        } else {
            map.put("code", -1);
            map.put("msg", "路线添加失败");
        }
        return map;
    }

    //获取所有起始站
    @RequestMapping("/getAllStartPlace")
    public Map<String, Object> getAllStartPlace() {
        Map<String, Object> map = new HashMap<>();
        List<String> allStartPlace = lineService.getAllStartPlace();
        if (allStartPlace.size() == 0) {
            map.put("code", -1);
            map.put("msg", "路线起始站信息获取失败");
        } else {
            map.put("code", 0);
            map.put("msg", "路线起始站信息获取成功");
            map.put("startPlaceList", allStartPlace);
        }
        return map;
    }

    //获取所有终点站
    @RequestMapping("/getAllEndPlace")
    public Map<String, Object> getAllEndPlace() {
        Map<String, Object> map = new HashMap<>();
        List<String> allEndPlace = lineService.getAllEndPlace();
        if (allEndPlace.size() == 0) {
            map.put("code", -1);
            map.put("msg", "路线终点站信息获取失败");
        } else {
            map.put("code", 0);
            map.put("msg", "路线终点站信息获取成功");
            map.put("endPlaceList", allEndPlace);
        }
        return map;
    }

    //获取所有线路
    @RequestMapping("/getAllLine")
    public Map<String, Object> getAllLine(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, size);
        List<Line> lines = lineService.getAllLine();
        if (lines.size() == 0) {
            map.put("code", -1);
            map.put("msg", "路线信息获取失败");
        } else {
            PageInfo<Line> lineList = new PageInfo<>(lines);
            map.put("code", 0);
            map.put("msg", "路线信息获取成功");
            map.put("lineList", lineList);
        }
        return map;
    }

    //根据路线id路线信息修改
    @RequestMapping("/updateLineByLineId")
    public Map<String, Object> updateLineByLineId(Integer lineId, String lineLevel, String lineName, String lineType, String startPlace, String endPlace, Integer day, BigDecimal price1, BigDecimal price2, Integer qp, Integer dp, String meetPlace, String meetPhone, String goTransport, String backTransport, String lineImage, String linePhone, Integer status, String djs, String bak, String weblog) {
        Map<String, Object> map = new HashMap<>();
        if (lineService.updateLineByLineId(lineId, lineLevel, lineName, lineType, startPlace, endPlace, day, price1, price2, qp, dp, meetPlace, meetPhone, goTransport, backTransport, lineImage, linePhone, status, djs, bak, weblog) != 0) {
            map.put("code", 0);
            map.put("msg", "线路信息修改成功");
        } else {
            map.put("code", -1);
            map.put("msg", "路线信息修改失败");
        }
        return map;
    }

    //多条件查询
    @RequestMapping("/getLineByMore")
    public Map<String, Object> getLineByMore(Integer lineId, String lineLevel, String lineName, String lineType, String startPlace, String endPlace, Integer day, BigDecimal price1, BigDecimal price2, Integer qp, Integer dp, String meetPlace, String meetPhone, String goTransport, String backTransport, String linePhone, Integer status, String djs, String bak, String weblog, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, size);
        List<Line> lines = lineService.getLineByMore(lineId, lineLevel, lineName, lineType, startPlace, endPlace, day, price1, price2, qp, dp, meetPlace, meetPhone, goTransport, backTransport, linePhone, status, djs, bak, weblog);
        if (lines.size() == 0) {
            map.put("code", -1);
            map.put("msg", "路线信息获取失败或未找到符合条件的路线");
        } else {
            PageInfo<Line> lineList = new PageInfo<>(lines);
            map.put("code", 0);
            map.put("msg", "路线信息获取成功");
            map.put("lineList", lineList);
        }
        return map;
    }

}
