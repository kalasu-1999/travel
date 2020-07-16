package com.example.demo.service.impl;

import com.example.demo.entity.Team;
import com.example.demo.mapper.TeamMapper;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl  implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    //显示全部旅行团
    @Override
    public List<Team> selectAllTeam() {
        return teamMapper.selectAll();
    }

    //根据旅行团id获取旅行团信息
    @Override
    public Team selectTeamByTeamId(Integer teamId) {
        return teamMapper.selectByPrimaryKey(teamId);
    }

    //根据旅行团id修改旅行团信息
    @Override
    public int updateTeamByTeamId(Team team) {
        return teamMapper.updateByPrimaryKey(team);
    }

    //添加旅行团信息
    @Override
    public int insertTeam(Team team) {
        return teamMapper.insert(team);
    }
}
