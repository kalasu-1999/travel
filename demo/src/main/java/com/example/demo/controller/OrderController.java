package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private LineTeamService lineTeamService;
    @Autowired
    private LineService lineService;
    @Autowired
    private ViewLineService viewLineService;
    @Autowired
    private ViewsService viewsService;
    @Autowired
    private TeamService teamService;

    //添加订单
    @RequestMapping("/insertOrder")
    public Map<String, Object> insertOrder(Integer guestId, Integer lineteamId, Integer adult, Integer child, String bak) {
        Map<String, Object> map = new HashMap<>();
        if (orderService.insertOrder(guestId, lineteamId, adult, child, bak) == 1) {
            map.put("code", 0);
            map.put("msg", "订单添加成功");
        } else {
            map.put("code", -1);
            map.put("msg", "订单添加失败");
        }
        return map;
    }

    //修改订单
    @RequestMapping("/updateOrder")
    public Map<String, Object> updateOrder(HttpServletRequest request, Integer orderId, Integer lineteamId, Integer adult, Integer child, String bak) {
        Map<String, Object> map = new HashMap<>();
        Guest guest = jwtService.verifyToken(request, "secret");
        if (guest != null) {
            if (orderService.updateOrder(orderId, guest.getGuestId(), lineteamId, adult, child, bak) == 1) {
                map.put("code", 0);
                map.put("msg", "订单修改成功");
            } else {
                map.put("code", -1);
                map.put("msg", "订单修改失败");
            }
        } else {
            map.put("code", -2);
            map.put("msg", "无法获取到用户信息");
        }
        return map;
    }

    //查询自己的全部订单
    @RequestMapping("/selectOrderByGuestId")
    public Map<String, Object> selectOrderByGuestId(HttpServletRequest request, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        Guest guest = jwtService.verifyToken(request, "secret");
        if (guest != null) {
            List<Order> orders = orderService.selectOrderByGuestId(guest.getGuestId());
            if (orders.size() != 0) {
                PageHelper.startPage(page, size);
                PageInfo<Order> pageInfo = new PageInfo<>(orders);
                map.put("code", 0);
                map.put("msg", "订单获取成功");
                map.put("data", pageInfo);
            } else {
                map.put("code", -1);
                map.put("msg", "订单获取失败或无订单");
            }
        } else {
            map.put("code", -2);
            map.put("msg", "无法获取到用户信息");
        }
        return map;
    }

    //查询所有订单
    @RequestMapping("/selectAllOrder")
    public Map<String, Object> selectAllOrder(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        List<Order> orders = orderService.selectAllOrder();
        if (orders.size() != 0) {
            PageHelper.startPage(page, size);
            PageInfo<Order> pageInfo = new PageInfo<>(orders);
            map.put("code", 0);
            map.put("msg", "订单获取成功");
            map.put("data", pageInfo);
        } else {
            map.put("code", -1);
            map.put("msg", "订单获取失败或无订单");
        }
        return map;
    }

    //修改订单标记
    @RequestMapping("/updateOrderTag")
    public Map<String, Object> updateOrderTag(Integer orderId, Integer tag) {
        Map<String, Object> map = new HashMap<>();
        if (orderService.updateOrderTag(orderId, tag) == 1) {
            map.put("code", 0);
            map.put("msg", "订单修改成功");
        } else {
            map.put("code", -1);
            map.put("msg", "订单修改失败");
        }
        return map;
    }

    //按订单标记查询
    @RequestMapping("/selectOrderByTag")
    public Map<String, Object> selectOrderByTag(Integer tag, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        List<Order> orders = orderService.selectOrderByTag(tag);
        if (orders.size() != 0) {
            PageHelper.startPage(page, size);
            PageInfo<Order> pageInfo = new PageInfo<>(orders);
            map.put("code", 0);
            map.put("msg", "订单获取成功");
            map.put("data", pageInfo);
        } else {
            map.put("code", -1);
            map.put("msg", "订单获取失败或无订单");
        }
        return map;
    }

    //获取订单详细信息
    @RequestMapping("/detail")
    public Map<String, Object> detail(Integer orderId) {
        Map<String, Object> map = new HashMap<>();
        Order order = orderService.selectOrderById(orderId);
        if (order == null) {
            map.put("code", -1);
            map.put("msg", "信息查询异常或无信息");
        } else {
            LineTeam lt = lineTeamService.selectByLineTeamId(order.getLineteamId());
            Map<String, Object> m = new HashMap<>();
            Line line = lineService.selectLineByLineId(lt.getLineId());
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
            Team team = teamService.selectTeamByTeamId(lt.getTeamId());
            m.put("line", line);
            m.put("team", team);
            m.put("lineTeam", lt);
            m.put("viewsList", viewsList);
            map.put("code", 0);
            map.put("msg", "信息查询成功");
            map.put("data", m);
        }
        return map;
    }
}
