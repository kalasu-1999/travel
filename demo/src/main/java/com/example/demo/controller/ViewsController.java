package com.example.demo.controller;

import com.example.demo.entity.Line;
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
@RequestMapping("views")
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
        List<Integer> lineIds = viewLineService.selectAllLine(viewId);
        if (lineIds.size() == 0){
            map.put("code",-1);
            map.put("msg","数据获取失败或未获取到数据");
        } else {
            List<Line> lineList = new ArrayList<>();
            for (Integer lineId : lineIds) {
                lineList.add(lineService.selectLineByLineId(lineId));
            }
            map.put("code", 0);
            map.put("msg", "数据获取成功");
            map.put("data",lineList);
        }
        return map;
    }

}
