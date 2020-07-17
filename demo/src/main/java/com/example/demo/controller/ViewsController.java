package com.example.demo.controller;

import com.example.demo.entity.Line;
import com.example.demo.entity.LineViews;
import com.example.demo.entity.Views;
import com.example.demo.service.LineService;
import com.example.demo.service.ViewLineService;
import com.example.demo.service.ViewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/views")
public class ViewsController {
    @Autowired
    private ViewsService viewsService;
    @Autowired
    private ViewLineService viewLineService;
    @Autowired
    private LineService lineService;

    //添加景点
    @RequestMapping("/insertViews")
    public Map<String, Object> insertViews(String viewName, String viewImage, String content) {
        Map<String, Object> map = new HashMap<>();
        if (viewsService.insertViews(viewName, viewImage, content) == 1) {
            map.put("code", 0);
            map.put("msg", "景点信息添加成功");
        } else {
            map.put("code", -1);
            map.put("msg", "景点信息添加失败");
        }
        return map;
    }

    //修改景点信息
    @RequestMapping("/updateViews")
    public Map<String, Object> updateViews(Integer viewId, String viewName, String viewImage, String content) {
        Map<String, Object> map = new HashMap<>();
        if (viewsService.updateViews(viewId, viewName, viewImage, content) == 1) {
            map.put("code", 0);
            map.put("msg", "景点信息更新成功");
        } else {
            map.put("code", -1);
            map.put("msg", "景点信息更新失败");
        }
        return map;
    }

    //根据景点id获取景点信息
    @RequestMapping("/selectViewsByViewId")
    public Map<String, Object> selectViewsByViewId(Integer viewId) {
        Map<String, Object> map = new HashMap<>();
        Views views = viewsService.selectViewsByViewId(viewId);
        if (views != null) {
            map.put("code", 0);
            map.put("msg", "景点信息获取成功");
            map.put("data", views);
        } else {
            map.put("code", -1);
            map.put("msg", "景点信息获取失败");
        }
        return map;
    }

    //根据hint进行模糊查询
    @RequestMapping("/selectViewsByHint")
    public Map<String, Object> selectViewsByHint(String hint, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, size);
        List<Views> views = viewsService.selectViewsByHint(hint);
        if (views.size() != 0) {
            PageInfo<Views> viewList = new PageInfo<>(views);
            map.put("code", 0);
            map.put("msg", "景点信息获取成功");
            map.put("data", viewList);
        } else {
            map.put("code", -1);
            map.put("msg", "景点信息获取失败");
        }
        return map;
    }

    //显示全部景点
    @RequestMapping("/selectAllViews")
    public Map<String, Object> selectAllViews(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, size);
        List<Views> views = viewsService.selectAllViews();
        if (views.size() != 0) {
            PageInfo<Views> viewList = new PageInfo<>(views);
            map.put("code", 0);
            map.put("msg", "景点信息获取成功");
            map.put("data", viewList);
        } else {
            map.put("code", -1);
            map.put("msg", "景点信息获取失败");
        }
        return map;
    }

    //根据景点id进行景点删除
    @RequestMapping("/deleteViewsByViewId")
    public Map<String, Object> deleteViewsByViewId(Integer viewId) {
        Map<String, Object> map = new HashMap<>();
        if (viewsService.deleteViewsByViewId(viewId) == 1) {
            viewLineService.deleteViewLineByViewId(viewId);
            map.put("code", 0);
            map.put("msg", "景点信息删除成功");
        } else {
            map.put("code", -1);
            map.put("msg", "景点信息删除失败");
        }
        return map;
    }

    //根据指定的景点id获取全部线路
    @RequestMapping("/selectAllLine")
    public Map<String, Object> selectAllLine(Integer viewId) {
        Map<String, Object> map = new HashMap<>();
        List<LineViews> lineViews = viewLineService.selectAllLine(viewId);
        if (lineViews.size() == 0){
            map.put("code",-1);
            map.put("msg","数据获取失败或未获取到数据");
        } else {
            List<Map<String,Object>> lineList = new ArrayList<>();
            for (LineViews lineView : lineViews) {
                Line line = lineService.selectLineByLineId(lineView.getLineId());
                Map<String,Object> m = new HashMap<>();
                m.put("lineViewsId",lineView.getLineviewsId());
                m.put("lineId",line.getLineId());
                m.put("lineLevel",line.getLineLevel());
                m.put("lineName",line.getLineName());
                m.put("lineType",line.getLineType());
                m.put("startPlace",line.getStartPlace());
                m.put("endPlace",line.getEndPlace());
                m.put("day",line.getDay());
                m.put("price1",line.getPrice1());
                m.put("price2",line.getPrice2());
                m.put("qp",line.getQp());
                m.put("dp",line.getDp());
                m.put("meetPlace",line.getMeetPlace());
                m.put("meetPhone",line.getMeetPhone());
                m.put("goTransport",line.getGoTransport());
                m.put("backTransport",line.getBackTransport());
                m.put("lineImage",line.getLineImage());
                m.put("linePhone",line.getLinePhone());
                m.put("status",line.getStatus());
                m.put("djs",line.getDjs());
                m.put("bak",line.getBak());
                m.put("weblog",line.getWeblog());
                lineList.add(m);
            }
            map.put("code", 0);
            map.put("msg", "数据获取成功");
            map.put("data",lineList);
        }
        return map;
    }

}
