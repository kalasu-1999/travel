package com.example.demo.service;

import com.example.demo.entity.Order;

import java.util.List;

public interface OrderService {
    //添加订单
    int insertOrder(Integer guestId, Integer lineteamId, Integer adult, Integer child, String bak);

    //修改订单
    int updateOrder(Integer orderId, Integer guestId, Integer lineteamId, Integer adult, Integer child, String bak);

    //查询自己的全部订单
    List<Order> selectOrderByGuestId(Integer guestId);

    //查询所有订单
    List<Order> selectAllOrder();

    //修改订单标记
    int updateOrderTag(Integer orderId,Integer tag);

    //按订单标记查询
    List<Order> selectOrderByTag(Integer tag);

    //根据订单号查询订单
    Order selectOrderById(Integer orderId);
}
