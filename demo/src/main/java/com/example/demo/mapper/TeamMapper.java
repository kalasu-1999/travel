package com.example.demo.mapper;

import com.example.demo.entity.Team;
import java.util.List;

public interface TeamMapper {
    int deleteByPrimaryKey(Integer teamId);

    int insert(Team record);

    Team selectByPrimaryKey(Integer teamId);

    List<Team> selectAll();

    int updateByPrimaryKey(Team record);
}