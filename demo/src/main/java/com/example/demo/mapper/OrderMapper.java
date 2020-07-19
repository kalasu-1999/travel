package com.example.demo.mapper;

import com.example.demo.entity.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    Order selectByPrimaryKey(Integer orderId);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);

    //根据用户id获取全部订单
    List<Order> selectOrderByGuestId(Integer guestId);

    //修改订单标记
    int updateOrderTag(Order record);

    //按订单标记查询
    List<Order> selectOrderByTag(Integer tag);

    Order selectOrderByOrderIdAndGuestId(Integer orderId, Integer guestId);
}