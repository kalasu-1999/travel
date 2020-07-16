package com.example.demo.service;

import com.example.demo.entity.Team;
import com.github.pagehelper.Page;

public interface TeamService {
    //显示全部旅行团
    Page<Team> selectAllTeam();
    //根据旅行团id获取旅行团信息
    Team selectTeamByTeamId(Integer teamId);
    //根据旅行团id修改旅行团信息
    int updateTeamByTeamId(String guide1, String guide2, String phone, String bak);
    //添加旅行团信息
    int insertTeam(String guide1, String guide2, String phone, String bak);
}
