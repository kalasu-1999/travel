package com.example.demo.service;

import java.util.List;

public interface ViewLineService {
    //添加景点和线路的对应信息
    int insertViewLine(Integer viewId,Integer lineId);

    //修改景点和线路的对应信息
    int updateViewLine(Integer lineviewsId, Integer lineId, Integer viewId);

    //根据id删除景点和线路的对应信息
    int deleteViewLine(Integer lineviewsId);

    //根据指定的景点id获取全部线路id
    List<Integer> selectAllLine(Integer viewId);

    //根据指定的线路id获取全部景点id
    List<Integer> selectAllView(Integer lineId);
}
