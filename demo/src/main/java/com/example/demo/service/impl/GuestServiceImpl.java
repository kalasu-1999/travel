package com.example.demo.service.impl;

import com.example.demo.entity.Guest;
import com.example.demo.entity.GuestInfo;
import com.example.demo.mapper.GuestInfoMapper;
import com.example.demo.mapper.GuestMapper;
import com.example.demo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.security.MessageDigest;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    private GuestMapper guestMapper;
    @Autowired
    private GuestInfoMapper guestInfoMapper;

    //管理员登录
    @Override
    public Guest adminLogin(String username, String password) {
        password = toMD5(password);
        return guestMapper.adminLogin(username, password);
    }

    //用户信息修改
    @Override
    public boolean updateGuestInfo(Integer guestId, String address, String phone, String email) {
        return guestInfoMapper.updateByGuestId(new GuestInfo(null, guestId, address, phone, email)) == 1;
    }

    //用户信息查询
    @Override
    public GuestInfo selectGuestInfoByGuestId(Integer guestId) {
        return guestInfoMapper.selectByGuestId(guestId);
    }

    //用户密码修改
    @Override
    public boolean changePassword(Guest guest) {
        try {
            guest.setPassword(toMD5(guest.getPassword()));
            int i = guestMapper.updateByPrimaryKey(guest);
            if (i == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //用户登录
    @Override
    public Guest loginGuest(String username, String password) {
        password = toMD5(password);//密码进行加密
        return guestMapper.selectByUsernameAndPassword(username, password);
    }

    //用户注册
    @Override
    @Transactional
    public Integer insertGuest(String username, String password, String address, String phone, String email) {
        if (guestMapper.selectByUsername(username) != null) {
            return -2;
        }
        password = toMD5(password);//密码进行加密
        Guest g = new Guest(null, username, password, 0);
        int i = guestMapper.insert(g);
        if (i == 0) {
            throw new RuntimeException("用户创建失败");
        }
        if (guestInfoMapper.insert(new GuestInfo(null, g.getGuestId(), address, phone, email)) == 0) {
            throw new RuntimeException("用户信息创建失败");
        }
        return 0;
    }

    //进行MD5加密
    private String toMD5(String code) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(code.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
