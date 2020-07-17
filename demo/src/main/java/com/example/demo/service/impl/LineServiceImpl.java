package com.example.demo.service.impl;

import com.example.demo.entity.Line;
import com.example.demo.mapper.LineMapper;
import com.example.demo.service.ImgUtilService;
import com.example.demo.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LineServiceImpl implements LineService {
    @Autowired
    private LineMapper lineMapper;
    @Autowired
    private ImgUtilService imgUtilService;

    @Override
    public int insertLine(
            String lineLevel,
            String lineName,
            String lineType,
            String startPlace,
            String endPlace,
            Integer day,
            BigDecimal price1,
            BigDecimal price2,
            Integer qp,
            Integer dp,
            String meetPlace,
            String meetPhone,
            String goTransport,
            String backTransport,
            String lineImage,
            String linePhone,
            Integer status,
            String djs,
            String bak,
            String weblog) {
        String img = imgUtilService.saveImg(lineImage);
        return lineMapper.insert(
                new Line(null,
                        lineLevel,
                        lineName,
                        lineType,
                        startPlace,
                        endPlace,
                        day,
                        price1,
                        price2,
                        qp,
                        dp,
                        meetPlace,
                        meetPhone,
                        goTransport,
                        backTransport,
                        img,
                        linePhone,
                        status,
                        djs,
                        bak,
                        weblog)
        );
    }

    @Override
    public List<String> getAllStartPlace() {
        return lineMapper.getAllStartPlace();
    }

    @Override
    public List<String> getAllEndPlace() {
        return lineMapper.getAllEndPlace();
    }

    @Override
    public List<Line> getAllLine() {
        List<Line> lines = lineMapper.selectAll();
        for (Line line : lines) {
            String lineImage = line.getLineImage();
            String imgPath = imgUtilService.getImgPath(lineImage);
            line.setLineImage(imgPath);
        }
        return lines;
    }

    @Override
    public int updateLineByLineId(Integer lineId, String lineLevel, String lineName, String lineType, String startPlace, String endPlace, Integer day, BigDecimal price1, BigDecimal price2, Integer qp, Integer dp, String meetPlace, String meetPhone, String goTransport, String backTransport, String lineImage, String linePhone, Integer status, String djs, String bak, String weblog) {
        Line line = lineMapper.selectByPrimaryKey(lineId);
        if (line == null) {
            return -1;
        } else {
            String[] split = lineImage.split("/");
            if (!split[split.length - 1].equals(line.getLineImage())) {
                imgUtilService.deleteImg(line.getLineImage());
                lineImage = imgUtilService.saveImg(lineImage);
            } else {
                lineImage = line.getLineImage();
            }
        }
        return lineMapper.updateByPrimaryKey(
                new Line(lineId,
                        lineLevel,
                        lineName,
                        lineType,
                        startPlace,
                        endPlace,
                        day,
                        price1,
                        price2,
                        qp,
                        dp,
                        meetPlace,
                        meetPhone,
                        goTransport,
                        backTransport,
                        lineImage,
                        linePhone,
                        status,
                        djs,
                        bak,
                        weblog));
    }

    //多条件查询
    @Override
    public List<Line> getLineByMore(Integer lineId, String lineLevel, String lineName, String lineType, String startPlace, String endPlace, Integer day, BigDecimal price1, BigDecimal price2, Integer qp, Integer dp, String meetPlace, String meetPhone, String goTransport, String backTransport, String linePhone, Integer status, String djs, String bak, String weblog) {
        List<Line> lines = lineMapper.selectLineByMore(new Line(lineId, lineLevel, lineName, lineType, startPlace, endPlace, day, price1, price2, qp, dp, meetPlace, meetPhone, goTransport, backTransport, null, linePhone, status, djs, bak, weblog));
        for (Line line : lines) {
            String lineImage = line.getLineImage();
            String imgPath = imgUtilService.getImgPath(lineImage);
            line.setLineImage(imgPath);
        }
        return lines;
    }

    //根据id获取
    @Override
    public Line selectLineByLineId(Integer lineId) {
        return lineMapper.selectByPrimaryKey(lineId);
    }
}
