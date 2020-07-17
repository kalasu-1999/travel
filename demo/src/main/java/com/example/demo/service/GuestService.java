package com.example.demo.service;

import com.example.demo.entity.Guest;
import com.example.demo.entity.GuestInfo;

public interface GuestService {
    //用户登录
    Guest loginGuest(String username, String password);

    //用户注册
    Integer insertGuest(String username, String password, String address, String phone, String email);

    //用户密码修改
    boolean changePassword(Guest guest);

    //用户信息修改
    boolean updateGuestInfo(Integer guestId, String address, String phone, String email);

    //用户信息查询
    GuestInfo selectGuestInfoByGuestId(Integer guestId);

    //管理员登录
    Guest adminLogin(String username, String password);
}
