package com.example.demo.controller;

import com.example.demo.entity.Guest;
import com.example.demo.entity.GuestInfo;
import com.example.demo.service.GuestService;
import com.example.demo.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;
    @Autowired
    private JWTService jwtService;

    //用户登录
    @RequestMapping("/login")
    public Map<String, Object> loginGuest(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        try {
            Guest guest = guestService.loginGuest(username, password);
            if (guest == null) {
                map.put("code", -2);
                map.put("msg", "用户名或密码错误");
            } else {
                String token = jwtService.createToken(guest.getGuestId(), guest.getName(), guest.getFlag());
                if (token != null) {
                    map.put("code", 0);
                    map.put("msg", "登录成功");
                    map.put("token", token);
                    map.put("flag", guest.getFlag());
                } else {
                    map.put("code", -3);
                    map.put("msg", "token创建失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", -1);
            map.put("msg", "登录出现异常");
        }
        return map;
    }

    //用户注册
    @RequestMapping("/insert")
    public Map<String, Object> insertGuest(String username, String password, String address, String phone, String email) {
        Map<String, Object> map = new HashMap<>();
        Integer integer = guestService.insertGuest(username, password, address, phone, email);
        if (integer == -2) {
            map.put("code", -2);
            map.put("msg", "用户名已存在");
        } else if (integer == 0) {
            map.put("code", 0);
            map.put("msg", "注册成功");
        } else {
            map.put("code", -1);
            map.put("msg", "注册出现异常");
        }
        return map;
    }

    //用户密码修改
    @RequestMapping("/changePassword")
    public Map<String, Object> changePassword(HttpServletRequest request, String password) {
        Map<String, Object> map = new HashMap<>();
        Guest guest = jwtService.verifyToken(request, "secret");
        if (guest != null) {
            guest.setPassword(password);
            if (guestService.changePassword(guest)) {
                map.put("code", 0);
                map.put("msg", "密码修改成功");
            } else {
                map.put("code", -1);
                map.put("msg", "密码修改失败");
            }
        } else {
            map.put("code", -2);
            map.put("msg", "从token获取用户信息失败");
        }
        return map;
    }

    //用户信息查询
    @RequestMapping("/selectGuestMessage")
    public Map<String, Object> selectGuestMessage(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Guest guest = jwtService.verifyToken(request, "secret");
        if (guest != null) {
            GuestInfo guestInfo = guestService.selectGuestInfoByGuestId(guest.getGuestId());
            map.put("code", 0);
            map.put("msg", "用户信息获取成功");
            map.put("data", guestInfo);
        } else {
            map.put("code", -1);
            map.put("msg", "从token获取用户信息失败");
        }
        return map;
    }

    //用户信息更新
    @RequestMapping("/updateGuestMessage")
    public Map<String, Object> updateGuestMessage(HttpServletRequest request, String address, String phone, String email) {
        Map<String, Object> map = new HashMap<>();
        Guest guest = jwtService.verifyToken(request, "secret");
        if (guest != null) {
            if (guestService.updateGuestInfo(guest.getGuestId(), address, phone, email)) {
                map.put("code", 0);
                map.put("msg", "用户信息更新成功");
            } else {
                map.put("code", -1);
                map.put("msg", "用户信息更新失败");
            }
        } else {
            map.put("code", -2);
            map.put("msg", "从token获取用户信息失败");
        }
        return map;
    }

    //管理员登录
    @RequestMapping("/adminLogin")
    public Map<String, Object> adminLogin(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        try {
            Guest guest = guestService.adminLogin(username, password);
            if (guest == null) {
                map.put("code", -2);
                map.put("msg", "用户名或密码错误");
            } else {
                String token = jwtService.createToken(guest.getGuestId(), guest.getName(), guest.getFlag());
                if (token != null) {
                    map.put("code", 0);
                    map.put("msg", "登录成功");
                    map.put("token", token);
                    map.put("flag", guest.getFlag());
                } else {
                    map.put("code", -3);
                    map.put("msg", "token创建失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", -1);
            map.put("msg", "登录出现异常");
        }
        return map;
    }

    //从HttpServletRequest中获取用户名
    @RequestMapping("/getUsername")
    public Map<String, Object> getUsername(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Guest guest = jwtService.verifyToken(request, "secret");
        if (guest != null) {
            map.put("code", 0);
            map.put("msg", "获取用户信息成功");
            map.put("data", guest.getName());
        } else {
            map.put("code", -2);
            map.put("msg", "从token获取用户信息失败");
        }
        return map;
    }
}
