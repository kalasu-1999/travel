package com.example.demo.service.impl;

import com.example.demo.entity.LineTeam;
import com.example.demo.mapper.LineTeamMapper;
import com.example.demo.service.LineTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LineTeamServiceImpl implements LineTeamService {
    @Autowired
    private LineTeamMapper lineTeamMapper;

    @Override
    public int insertLineTeam(Integer teamId, Integer lineId, String goDate, String backDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date go = null;
            Date back = null;
            if (goDate != null && !goDate.equals("")) {
                go = simpleDateFormat.parse(goDate);
            }
            if (backDate != null && !backDate.equals("")) {
                back = simpleDateFormat.parse(backDate);
            }
            return lineTeamMapper.insert(new LineTeam(null, teamId, lineId, go, back, 0, 0));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateLineTeam(Integer lineteamId, Integer teamId, Integer lineId, String goDate, String backDate, Integer adult, Integer child) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            LineTeam lineTeam = lineTeamMapper.selectByPrimaryKey(lineteamId);
            Date go;
            Date back;
            if (goDate != null && !goDate.equals("")) {
                go = simpleDateFormat.parse(goDate);
            } else {
                go = lineTeam.getGoDate();
            }
            if (backDate != null && !backDate.equals("")) {
                back = simpleDateFormat.parse(backDate);
            } else {
                back = lineTeam.getBackDate();
            }
            return lineTeamMapper.updateByPrimaryKey(new LineTeam(lineteamId, teamId, lineId, go, back, adult, child));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
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
    public List<LineTeam> selectLineTeamByMore(Integer lineteamId, Integer teamId, Integer lineId, String goDate, String backDate, Integer adult, Integer child) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date go = null;
            Date back = null;
            if (goDate != null && !goDate.equals("")) {
                go = simpleDateFormat.parse(goDate);
            }
            if (backDate != null && !backDate.equals("")) {
                back = simpleDateFormat.parse(backDate);
            }
            return lineTeamMapper.selectLineTeamByMore(new LineTeam(lineteamId, teamId, lineId, go, back, adult, child));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public LineTeam selectByLineTeamId(Integer lineteamId) {
        return lineTeamMapper.selectByPrimaryKey(lineteamId);
    }

    @Override
    public List<LineTeam> selectByTables(Integer teamId, String bak, Integer lineTeamId, String goDate, Integer lineId, String lineName, String startPlace, String endPlace, Integer viewId, String viewName) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date go;
            if (goDate == null || goDate.equals("")) {
                go = simpleDateFormat.parse(simpleDateFormat.format(System.currentTimeMillis()));
            } else {
                go = simpleDateFormat.parse(goDate);
            }
            return lineTeamMapper.selectByTables(teamId, bak, lineTeamId, go, lineId, lineName, startPlace, endPlace, viewId, viewName);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
