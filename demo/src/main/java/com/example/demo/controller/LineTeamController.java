package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lineTeam")
public class LineTeamController {
    @Autowired
    private LineTeamService lineTeamService;
    @Autowired
    private LineService lineService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private ViewLineService viewLineService;
    @Autowired
    private ViewsService viewsService;
    @Autowired
    private ImgUtilService imgUtilService;

    //添加路线-旅行团对应信息
    @RequestMapping("/insertLineTeam")
    public Map<String, Object> insertLineTeam(Integer teamId, Integer lineId, String goDate, String backDate) {
        Map<String, Object> map = new HashMap<>();
        if (teamId == null) {
            map.put("code", -2);
            map.put("msg", "旅行团id不能为空");
        } else if (lineId == null) {
            map.put("code", -2);
            map.put("msg", "路线id不能为空");
        } else if (goDate == null || goDate.equals("")) {
            map.put("code", -2);
            map.put("msg", "出发时间不能为空");
        } else if (backDate == null || backDate.equals("")) {
            map.put("code", -2);
            map.put("msg", "返程时间不能为空");
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String s = format.format(System.currentTimeMillis());
            if (goDate.compareTo(s) < 0 || backDate.compareTo(goDate) < 0) {
                map.put("code", -2);
                map.put("msg", "日期错误");
                return map;
            }
            if (lineTeamService.insertLineTeam(teamId, lineId, goDate, backDate) == 1) {
                map.put("code", 0);
                map.put("msg", "信息添加成功");
            } else {
                map.put("code", -1);
                map.put("msg", "信息添加失败");
            }
        }
        return map;
    }

    //修改路线-旅行团对应信息
    @RequestMapping("/updateLineTeam")
    public Map<String, Object> updateLineTeam(Integer lineteamId, Integer teamId, Integer lineId, String goDate, String backDate, Integer adult, Integer child) {
        Map<String, Object> map = new HashMap<>();
        if (teamId == null) {
            map.put("code", -2);
            map.put("msg", "旅行团id不能为空");
        } else if (lineId == null) {
            map.put("code", -2);
            map.put("msg", "路线id不能为空");
        } else if (goDate == null || goDate.equals("")) {
            map.put("code", -2);
            map.put("msg", "出发时间不能为空");
        } else if (backDate == null || backDate.equals("")) {
            map.put("code", -2);
            map.put("msg", "返程时间不能为空");
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String s = format.format(System.currentTimeMillis());
            if (goDate.compareTo(s) < 0 || backDate.compareTo(goDate) < 0) {
                map.put("code", -2);
                map.put("msg", "日期错误");
                return map;
            }
            if (lineTeamService.updateLineTeam(lineteamId, teamId, lineId, goDate, backDate, adult, child) == 1) {
                map.put("code", 0);
                map.put("msg", "信息修改成功");
            } else {
                map.put("code", -1);
                map.put("msg", "信息修改失败");
            }
        }
        return map;
    }

    //查询所有路线-旅行团对应信息
    @RequestMapping("/selectAll")
    public Map<String, Object> selectAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, size);
        List<Map<String, Object>> list = new ArrayList<>();
        List<LineTeam> lineTeams = lineTeamService.selectAll();
        if (lineTeams.size() == 0) {
            map.put("code", -1);
            map.put("msg", "信息查询异常或无信息");
        } else {
            for (LineTeam lineTeam : lineTeams) {
                Map<String, Object> m = new HashMap<>();
                Line line = lineService.selectLineByLineId(lineTeam.getLineId());
                if (line.getStatus() == 0) {
                    List<LineViews> lineViews = viewLineService.selectAllView(line.getLineId());
                    List<Map<String, Object>> viewsList = new ArrayList<>();
                    for (LineViews lineView : lineViews) {
                        Views views = viewsService.selectViewsByViewId(lineView.getViewId());
                        Map<String, Object> t = new HashMap<>();
                        t.put("viewId", views.getViewId());
                        t.put("viewName", views.getViewName());
                        t.put("viewImage", views.getViewImage());
                        t.put("content", views.getContent());
                        t.put("lineViewsId", lineView.getLineviewsId());
                        viewsList.add(t);
                    }
                    line.setLineImage(imgUtilService.getImgPath(line.getLineImage()));
                    Team team = teamService.selectTeamByTeamId(lineTeam.getTeamId());
                    m.put("line", line);
                    m.put("team", team);
                    m.put("lineTeam", lineTeam);
                    m.put("viewsList", viewsList);
                    list.add(m);
                }
            }
            PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
            map.put("code", 0);
            map.put("msg", "信息查询成功");
            map.put("data", pageInfo);
        }
        return map;
    }

    //多条件查询
    @RequestMapping("/selectByMore")
    public Map<String, Object> selectByMore(Integer teamId, String bak, Integer lineTeamId, String goDate, Integer lineId, String lineName, String startPlace, String endPlace, Integer viewId, String viewName, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, size);
        List<Map<String, Object>> list = new ArrayList<>();
        if (goDate != null && !goDate.equals("")) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String s = format.format(System.currentTimeMillis());
            if (goDate.compareTo(s) < 0) {
                map.put("code", -2);
                map.put("msg", "日期错误");
                return map;
            }
        }
        List<LineTeam> lineTeams = lineTeamService.selectByTables(teamId, bak, lineTeamId, goDate, lineId, lineName, startPlace, endPlace, viewId, viewName);
        if (lineTeams.size() == 0) {
            map.put("code", -1);
            map.put("msg", "信息查询异常或无信息");
        } else {
            for (LineTeam lineTeam : lineTeams) {
                Map<String, Object> m = new HashMap<>();
                Line line = lineService.selectLineByLineId(lineTeam.getLineId());
                List<LineViews> lineViews = viewLineService.selectAllView(line.getLineId());
                List<Map<String, Object>> viewsList = new ArrayList<>();
                for (LineViews lineView : lineViews) {
                    Views views = viewsService.selectViewsByViewId(lineView.getViewId());
                    Map<String, Object> t = new HashMap<>();
                    t.put("viewId", views.getViewId());
                    t.put("viewName", views.getViewName());
                    t.put("viewImage", views.getViewImage());
                    t.put("content", views.getContent());
                    t.put("lineViewsId", lineView.getLineviewsId());
                    viewsList.add(t);
                }
                Team team = teamService.selectTeamByTeamId(lineTeam.getTeamId());
                line.setLineImage(imgUtilService.getImgPath(line.getLineImage()));
                m.put("line", line);
                m.put("team", team);
                m.put("lineTeam", lineTeam);
                m.put("viewsList", viewsList);
                list.add(m);
            }
            PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
            map.put("code", 0);
            map.put("msg", "信息查询成功");
            map.put("data", pageInfo);
        }
        return map;
    }

    //删除
    @RequestMapping("/delete")
    public Map<String, Object> deleteLineTeam(Integer lineteamId) {
        Map<String, Object> map = new HashMap<>();
        if (lineteamId == null) {
            map.put("code", -2);
            map.put("msg", "旅行团线路对应id不能为空");
        } else {
            if (lineTeamService.deleteLineTeam(lineteamId) == 1) {
                map.put("code", 0);
                map.put("msg", "信息修改成功");
            } else {
                map.put("code", -1);
                map.put("msg", "信息修改失败");
            }
        }
        return map;
    }
}
