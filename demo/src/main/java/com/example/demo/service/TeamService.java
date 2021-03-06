package com.example.demo.service;

import com.example.demo.entity.Team;

import java.util.List;

public interface TeamService {
    //显示全部旅行团
    List<Team> selectAllTeam();

    //多条件查询
    List<Team> selectTeamByMore(Integer teamId, Integer companyId, String guide1, String guide2, String phone, String bak);

    //根据旅行团id修改旅行团信息
    int updateTeamByTeamId(Integer teamId,String guide1, String guide2, String phone, String bak);

    //添加旅行团信息
    int insertTeam(String guide1, String guide2, String phone, String bak);

    //根据id获取
    Team selectTeamByTeamId(Integer teamId);

    //删除旅行团
    int deleteTeam(Integer teamId);
}
