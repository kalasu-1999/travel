package com.example.demo.controller;

import com.example.demo.entity.News;
import com.example.demo.entity.Team;
import com.example.demo.service.NewsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    //显示所有新闻按时间排序
    @RequestMapping("/selectAllNews")
    public Map<String, Object> selectAllNews(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, size);
        Page<News> news = newsService.selectAllNews();
        if (news.isEmpty()) {
            map.put("code", -1);
            map.put("msg", "新闻信息获取失败");
        } else {
            map.put("code", 0);
            map.put("msg", "新闻信息获取成功");
            map.put("data", news);
        }
        return map;
    }

    //添加新闻
    @RequestMapping("/insertNews")
    public Map<String, Object> insertNews(String title, String show) {
        Map<String, Object> map = new HashMap<>();
        if (newsService.insertNews(title, show) == 1) {
            map.put("code", 0);
            map.put("msg", "新闻添加成功");
        } else {
            map.put("code", -1);
            map.put("msg", "新闻添加失败");
        }
        return map;
    }

    //根据新闻id修改新闻标识
    @RequestMapping("/updateNewsByNewsId")
    public Map<String, Object> updateNewsByNewsId(Integer newsId) {
        Map<String, Object> map = new HashMap<>();
        if (newsService.updateNewsByNewsId(newsId) == 1) {
            map.put("code", 0);
            map.put("msg", "新闻信息修改成功");
        } else {
            map.put("code", -1);
            map.put("msg", "新闻信息修改失败");
        }
        return map;
    }

    //根据标题信息模糊查询
    @RequestMapping("/selectNewsByHint")
    public Map<String, Object> selectNewsByHint(String hint, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, size);
        Page<News> news = newsService.selectNewsByHint(hint);
        if (news.isEmpty()) {
            map.put("code", -1);
            map.put("msg", "新闻信息获取失败");
        } else {
            map.put("code", 0);
            map.put("msg", "新闻信息获取成功");
            map.put("data", news);
        }
        return map;
    }
}
