package com.example.demo.service.impl;

import com.example.demo.entity.LineViews;
import com.example.demo.mapper.LineViewsMapper;
import com.example.demo.service.ViewLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewLineServiceImpl implements ViewLineService {
    @Autowired
    private LineViewsMapper lineViewsMapper;

    @Override
    public int insertViewLine(Integer viewId, Integer lineId) {
        return lineViewsMapper.insert(new LineViews(null, viewId, lineId));
    }

    @Override
    public int updateViewLine(Integer lineviewsId, Integer lineId, Integer viewId) {
        return lineViewsMapper.updateByPrimaryKey(new LineViews(lineviewsId, lineId, viewId));
    }

    @Override
    public int deleteViewLine(Integer lineviewsId) {
        return lineViewsMapper.deleteByPrimaryKey(lineviewsId);
    }

    @Override
    public List<LineViews> selectAllLine(Integer viewId) {
        return lineViewsMapper.selectAllLine(viewId);
    }

    @Override
    public int deleteViewLineByViewId(Integer viewId) {
        return lineViewsMapper.deleteViewLineByViewId(viewId);
    }

    @Override
    public List<LineViews> selectAllView(Integer lineId) {
        return lineViewsMapper.selectAllView(lineId);
    }
}
