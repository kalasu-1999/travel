package com.example.demo.mapper;

import com.example.demo.entity.LineTeam;
import java.util.List;

public interface LineTeamMapper {
    int deleteByPrimaryKey(Integer lineteamId);

    int insert(LineTeam record);

    LineTeam selectByPrimaryKey(Integer lineteamId);

    List<LineTeam> selectAll();

    int updateByPrimaryKey(LineTeam record);

    //修改人数
    int addPeople(LineTeam record);

    //多条件查询
    List<LineTeam> selectLineTeamByMore(LineTeam record);
}