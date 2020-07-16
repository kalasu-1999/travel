package com.example.demo.mapper;

import com.example.demo.entity.GuestInfo;
import java.util.List;

public interface GuestInfoMapper {
    //根据用户信息表id删除用户信息
    int deleteByPrimaryKey(Integer id);

    //添加用户信息
    int insert(GuestInfo record);

    //根据用户信息表id获取用户信息
    GuestInfo selectByPrimaryKey(Integer id);

    //获取全部的用户信息
    List<GuestInfo> selectAll();

    //根据用户信息表id更新用户信息
    int updateByPrimaryKey(GuestInfo record);

    //根据用户id获取用户信息
    GuestInfo selectByGuestId(Integer guestId);

    //根据用户id修改用户信息
    int updateByGuestId(GuestInfo record);
}