package com.example.demo.mapper;

import com.example.demo.entity.Views;
import java.util.List;

public interface ViewsMapper {
    int deleteByPrimaryKey(Integer viewId);

    int insert(Views record);

    Views selectByPrimaryKey(Integer viewId);

    List<Views> selectAll();

    int updateByPrimaryKey(Views record);

    //根据hint进行模糊查询
    List<Views> selectByHint(String hint);

}