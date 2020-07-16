package com.example.demo.service;

import com.example.demo.entity.Guest;

import javax.servlet.http.HttpServletRequest;

public interface JWTService {
    String createToken(Integer guestId, String username,Integer flag);
    Guest verifyToken(HttpServletRequest request, String key);
}
