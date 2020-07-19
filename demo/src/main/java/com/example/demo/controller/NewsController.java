package com.example.demo.controller;

import com.example.demo.entity.News;
import com.example.demo.service.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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
        List<News> news = newsService.selectAllNews();
        PageInfo<News> pageInfo = new PageInfo<>(news);
        if (news.isEmpty()) {
            map.put("code", -1);
            map.put("msg", "新闻信息获取失败");
        } else {
            map.put("code", 0);
            map.put("msg", "新闻信息获取成功");
            map.put("data", pageInfo);
        }
        return map;
    }

    //添加新闻
    @RequestMapping("/insertNews")
    public Map<String, Object> insertNews(String title, String show) {
        Map<String, Object> map = new HashMap<>();
        if (title == null || title.equals("")) {
            map.put("code", -2);
            map.put("msg", "标题不能为空");
        } else if (show == null || show.equals("")) {
            map.put("code", -2);
            map.put("msg", "内容不能为空");
        } else {
            if (newsService.insertNews(title, show) == 1) {
                map.put("code", 0);
                map.put("msg", "新闻添加成功");
            } else {
                map.put("code", -1);
                map.put("msg", "新闻添加失败");
            }
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
        List<News> news = newsService.selectNewsByHint(hint);
        PageInfo<News> pageInfo = new PageInfo<>(news);
        if (news.isEmpty()) {
            map.put("code", -1);
            map.put("msg", "新闻信息获取失败");
        } else {
            map.put("code", 0);
            map.put("msg", "新闻信息获取成功");
            map.put("data", pageInfo);
        }
        return map;
    }

    //修改新闻信息
    @RequestMapping("/update")
    public Map<String, Object> updateNews(Integer newsId, String title, String show) {
        Map<String, Object> map = new HashMap<>();
        if (newsId == null){
            map.put("code", -2);
            map.put("msg", "新闻id不能为空");
        } else if (title == null || title.equals("")) {
            map.put("code", -2);
            map.put("msg", "标题不能为空");
        } else if (show == null || show.equals("")) {
            map.put("code", -2);
            map.put("msg", "内容不能为空");
        } else {
            if (newsService.updateNews(newsId, title, show) == 1) {
                map.put("code", 0);
                map.put("msg", "新闻修改成功");
            } else {
                map.put("code", -1);
                map.put("msg", "新闻修改失败");
            }
        }
        return map;
    }
}
