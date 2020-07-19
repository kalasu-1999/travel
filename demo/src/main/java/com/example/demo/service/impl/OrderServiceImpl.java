package com.example.demo.service.impl;

import com.example.demo.entity.LineTeam;
import com.example.demo.entity.Order;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.LineTeamService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private LineTeamService lineTeamService;

    @Override
    public int updateOrderTag(Integer orderId, Integer tag) {
        return orderMapper.updateOrderTag(new Order(orderId, null, null, null, null, tag, null));
    }

    @Override
    public List<Order> selectOrderByTag(Integer tag) {
        return orderMapper.selectOrderByTag(tag);
    }

    @Override
    public int insertOrder(Integer guestId, Integer lineteamId, Integer adult, Integer child, String bak) {
        LineTeam lineTeam = lineTeamService.selectByLineTeamId(lineteamId);
        if (lineTeam == null) {
            return 0;
        } else if (lineTeam.getAdult() + lineTeam.getChild() + adult + child > 50) {
            return -2;
        } else {
            lineTeamService.addPeople(lineteamId, adult, child);
            return orderMapper.insert(new Order(null, guestId, lineteamId, adult, child, 0, bak));
        }
    }

    @Override
    public Order selectOrderById(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateOrder(Integer orderId, Integer guestId, Integer lineteamId, Integer adult, Integer child, String bak) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        LineTeam lineTeam = lineTeamService.selectByLineTeamId(lineteamId);
        if (lineTeam == null) {
            return 0;
        } else if (lineTeam.getAdult() + lineTeam.getChild() + adult + child - order.getAdult() - order.getChild() > 50) {
            return -2;
        } else {
            lineTeamService.addPeople(lineteamId, adult - order.getAdult(), child - order.getChild());
            return orderMapper.updateByPrimaryKey(new Order(orderId, guestId, lineteamId, adult, child, null, bak));
        }
    }

    @Override
    public List<Order> selectOrderByGuestId(Integer guestId) {
        return orderMapper.selectOrderByGuestId(guestId);
    }

    @Override
    public List<Order> selectAllOrder() {
        return orderMapper.selectAll();
    }

    @Override
    public int deleteOrder(Integer orderId, Integer guestId) {
        Order order = orderMapper.selectOrderByOrderIdAndGuestId(orderId, guestId);
        if (order != null) {
            lineTeamService.addPeople(order.getLineteamId(), -order.getAdult(), -order.getChild());
            return orderMapper.deleteByPrimaryKey(orderId);
        } else {
            return 0;
        }
    }
}
