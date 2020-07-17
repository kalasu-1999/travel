package com.example.demo.service;

import com.example.demo.entity.LineTeam;

import java.util.Date;
import java.util.List;

public interface LineTeamService {
    //添加路线-旅行团对应信息
    int insertLineTeam(Integer teamId, Integer lineId, Date goDate, Date backDate);

    //修改路线-旅行团对应信息
    int updateLineTeam(Integer lineteamId, Integer teamId, Integer lineId, Date goDate, Date backDate, Integer adult, Integer child);

    //查询所有路线-旅行团对应信息
    List<LineTeam> selectAll();

    //修改人数（直接增加输入的值）
    void addPeople(Integer lineteamId, Integer adult, Integer child);

    //多条件查询
    List<LineTeam> selectLineTeamByMore(Integer lineteamId, Integer teamId, Integer lineId, Date goDate, Date backDate, Integer adult, Integer child);

    //多表联查
    List<LineTeam> selectByTables(Integer teamId, String bak, Integer lineTeamId, Date goDate, Integer lineId, String lineName, String startPlace, String endPlace, Integer viewId, String viewName);

    //根据id获取信息
    LineTeam selectByLineTeamId(Integer lineteamId);
}
