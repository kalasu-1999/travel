package com.example.demo.controller;

import com.example.demo.service.ViewLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/lineViews")
public class LineViewsController {
    @Autowired
    private ViewLineService viewLineService;

    //添加景点和线路的对应信息
    @RequestMapping("/insertViewLine")
    public Map<String, Object> insertViewLine(Integer viewId, Integer lineId) {
        Map<String, Object> map = new HashMap<>();
        if (viewId == null) {
            map.put("code", -2);
            map.put("msg", "景点id不能为空");
        } else if (lineId == null) {
            map.put("code", -2);
            map.put("msg", "路线id不能为空");
        } else {
            if (viewLineService.insertViewLine(viewId, lineId) == 1) {
                map.put("code", 0);
                map.put("msg", "景点线路对应信息添加成功");
            } else {
                map.put("code", -1);
                map.put("msg", "景点线路对应信息添加失败");
            }
        }
        return map;
    }

    //修改景点和线路的对应信息
    @RequestMapping("/updateViewLine")
    public Map<String, Object> updateViewLine(Integer lineViewsId, Integer lineId, Integer viewId) {
        Map<String, Object> map = new HashMap<>();
        if (viewId == null) {
            map.put("code", -2);
            map.put("msg", "景点id不能为空");
        } else if (lineId == null) {
            map.put("code", -2);
            map.put("msg", "路线id不能为空");
        } else {
            if (viewLineService.updateViewLine(lineViewsId, lineId, viewId) == 1) {
                map.put("code", 0);
                map.put("msg", "景点线路对应信息修改成功");
            } else {
                map.put("code", -1);
                map.put("msg", "景点线路对应信息修改失败");
            }
        }
        return map;
    }

    //根据id删除景点和线路的对应信息
    @RequestMapping("/deleteViewLine")
    public Map<String, Object> deleteViewLine(Integer lineViewsId) {
        Map<String, Object> map = new HashMap<>();
        if (viewLineService.deleteViewLine(lineViewsId) == 1) {
            map.put("code", 0);
            map.put("msg", "景点线路对应信息删除成功");
        } else {
            map.put("code", -1);
            map.put("msg", "景点线路对应信息删除失败");
        }
        return map;
    }
}
