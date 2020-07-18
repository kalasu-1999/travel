package com.example.demo.service.impl;

import com.example.demo.entity.Team;
import com.example.demo.mapper.TeamMapper;
import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    //显示全部旅行团
    @Override
    public List<Team> selectAllTeam() {
        return teamMapper.selectAll();
    }

    //多条件查询
    @Override
    public List<Team> selectTeamByMore(Integer teamId, Integer companyId, String guide1, String guide2, String phone, String bak) {
        return teamMapper.selectTeamByMore(new Team(teamId, companyId, guide1, guide2, phone, bak));
    }

    //根据旅行团id修改旅行团信息
    @Override
    public int updateTeamByTeamId(Integer teamId, String guide1, String guide2, String phone, String bak) {
        return teamMapper.updateByPrimaryKey(new Team(teamId, 1, guide1, guide2, phone, bak));
    }

    //添加旅行团信息
    @Override
    public int insertTeam(String guide1, String guide2, String phone, String bak) {
        return teamMapper.insert(new Team(null, 1, guide1, guide2, phone, bak));
    }

    @Override
    public Team selectTeamByTeamId(Integer teamId) {
        return teamMapper.selectByPrimaryKey(teamId);
    }
}
