package com.example.demo.service;

import com.example.demo.entity.Team;

import java.util.List;

public interface TeamService {
    //显示全部旅行团
    List<Team> selectAllTeam();
    //根据旅行团id获取旅行团信息
    Team selectTeamByTeamId(Integer teamId);
    //根据旅行团id修改旅行团信息
    int updateTeamByTeamId(Team team);
    //添加旅行团信息
    int insertTeam(Team team);
}
