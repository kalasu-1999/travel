package com.example.demo.service.impl;

import com.example.demo.entity.Team;
import com.example.demo.mapper.TeamMapper;
import com.example.demo.service.TeamService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl  implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    //显示全部旅行团
    @Override
    public Page<Team> selectAllTeam() {
        return (Page<Team>) teamMapper.selectAll();
    }

    //根据旅行团id获取旅行团信息
    @Override
    public Team selectTeamByTeamId(Integer teamId) {
        return teamMapper.selectByPrimaryKey(teamId);
    }

    //根据旅行团id修改旅行团信息
    @Override
    public int updateTeamByTeamId(String guide1, String guide2, String phone, String bak) {
        return teamMapper.updateByPrimaryKey(new Team(null,1,guide1,guide2,phone,bak));
    }

    //添加旅行团信息
    @Override
    public int insertTeam(String guide1, String guide2, String phone, String bak) {
        return teamMapper.insert(new Team(null,1,guide1,guide2,phone,bak));
    }
}
