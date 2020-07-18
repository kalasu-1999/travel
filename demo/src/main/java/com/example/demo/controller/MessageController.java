package com.example.demo.controller;

import com.example.demo.entity.Guest;
import com.example.demo.service.JWTService;
import com.example.demo.service.MessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private JWTService jwtService;

    //添加留言
    @RequestMapping("/insertMessage")
    public Map<String, Object> insertMessage(HttpServletRequest request, String title, String content) {
        Map<String, Object> map = new HashMap<>();
        Guest guest = jwtService.verifyToken(request, "secret");
        if (guest == null) {
            map.put("code", 401);
            map.put("msg", "登录失效");
        } else {
            if (messageService.insertMessage(guest.getGuestId(), title, content) == 1) {
                map.put("code", 0);
                map.put("msg", "留言添加成功");
            } else {
                map.put("code", -1);
                map.put("msg", "留言添加失败");
            }
        }
        return map;
    }

    //查询全部留言，按留言id倒序排列
    @RequestMapping("/selectAllMessage")
    public Map<String, Object> selectAllMessage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, size);
        List<Map<String, Object>> messageList = messageService.selectAllMessage();
        PageInfo<Map<String, Object>> messages = new PageInfo<>(messageList);
        if (messageList.isEmpty()) {
            map.put("code", -1);
            map.put("msg", "留言信息获取失败");
        } else {
            map.put("code", 0);
            map.put("msg", "留言信息获取成功");
            map.put("data", messages);
        }
        return map;
    }

    //根据留言id删除留言
    @RequestMapping("/deleteMessage")
    public Map<String, Object> deleteMessage(Integer messageId) {
        Map<String, Object> map = new HashMap<>();
        if (messageService.deleteMessage(messageId) == 1) {
            map.put("code", 0);
            map.put("msg", "留言删除成功");
        } else {
            map.put("code", -1);
            map.put("msg", "留言删除失败");
        }
        return map;
    }

    //查看用户自己的留言，按留言id倒序排序
    @RequestMapping("/selectMessageByGuestId")
    public Map<String, Object> selectMessageByGuestId(HttpServletRequest request, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        Guest guest = jwtService.verifyToken(request, "secret");
        if (guest == null) {
            map.put("code", 401);
            map.put("msg", "登录失效");
        } else {
            PageHelper.startPage(page, size);
            List<Map<String, Object>> messageList = messageService.selectMessageByGuestId(guest.getGuestId());
            PageInfo<Map<String, Object>> messages = new PageInfo<>(messageList);
            if (messageList.isEmpty()) {
                map.put("code", -1);
                map.put("msg", "留言信息获取失败");
            } else {
                map.put("code", 0);
                map.put("msg", "留言信息获取成功");
                map.put("data", messages);
            }
        }
        return map;
    }
}
