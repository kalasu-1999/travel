package com.example.demo.service.impl;

import com.example.demo.entity.LineTeam;
import com.example.demo.mapper.LineTeamMapper;
import com.example.demo.service.LineTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LineTeamServiceImpl implements LineTeamService {
    @Autowired
    private LineTeamMapper lineTeamMapper;

    @Override
    public int insertLineTeam(Integer teamId, Integer lineId, Date goDate, Date backDate) {
        return lineTeamMapper.insert(new LineTeam(null, teamId, lineId, goDate, backDate, 0, 0));
    }

    @Override
    public int updateLineTeam(Integer lineteamId, Integer teamId, Integer lineId, Date goDate, Date backDate, Integer adult, Integer child) {
        return lineTeamMapper.updateByPrimaryKey(new LineTeam(lineteamId, teamId, lineId, goDate, backDate, adult, child));
    }

    @Override
    public List<LineTeam> selectAll() {
        return lineTeamMapper.selectAll();
    }

    @Override
    public void addPeople(Integer lineteamId, Integer adult, Integer child) {
        lineTeamMapper.addPeople(new LineTeam(lineteamId, null, null, null, null, adult, child));
    }

    @Override
    public List<LineTeam> selectLineTeamByMore(Integer lineteamId, Integer teamId, Integer lineId, Date goDate, Date backDate, Integer adult, Integer child) {
        return lineTeamMapper.selectLineTeamByMore(new LineTeam(lineteamId, teamId, lineId, goDate, backDate, adult, child));
    }

    @Override
    public LineTeam selectByLineTeamId(Integer lineteamId) {
        return lineTeamMapper.selectByPrimaryKey(lineteamId);
    }

    @Override
    public List<LineTeam> selectByTables(Integer teamId, String bak, Integer lineTeamId, Date goDate, Integer lineId, String lineName, String startPlace, String endPlace, Integer viewId, String viewName) {
        return lineTeamMapper.selectByTables(teamId, bak, lineTeamId, goDate, lineId, lineName, startPlace, endPlace, viewId, viewName);
    }
}
