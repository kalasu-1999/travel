package com.example.demo.mapper;

import com.example.demo.entity.Guest;
import java.util.List;

public interface GuestMapper {
    //根据用户id删除用户信息
    int deleteByPrimaryKey(Integer guestId);

    //添加新用户
    int insert(Guest record);

    //根据用户id对用户信息进行检索
    Guest selectByPrimaryKey(Integer guestId);

    //获取所有用户信息
    List<Guest> selectAll();

    //根据用户id进行用户信息更新
    int updateByPrimaryKey(Guest record);

    //根据用户名进行用户查重
    Guest selectByUsername(String username);

    //根据用户名和密码进行登录判断
    Guest selectByUsernameAndPassword(String username,String password);
}