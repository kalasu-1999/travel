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
    public List<Line> getLineByStartPlace(String startPlace) {
        List<Line> lines = lineMapper.getLineByStartPlace(startPlace);
        for (Line line : lines) {
            String lineImage = line.getLineImage();
            String imgPath = imgUtilService.getImgPath(lineImage);
            line.setLineImage(imgPath);
        }
        return lines;
    }

    @Override
    public List<Line> getLineByEndPlace(String endPlace) {
        List<Line> lines = lineMapper.getLineByEndPlace(endPlace);
        for (Line line : lines) {
            String lineImage = line.getLineImage();
            String imgPath = imgUtilService.getImgPath(lineImage);
            line.setLineImage(imgPath);
        }
        return lines;
    }

    @Override
    public List<Line> getLineByStartPlaceAndEndPlace(String startPlace, String endPlace) {
        List<Line> lines = lineMapper.getLineByStartPlaceAndEndPlace(startPlace, endPlace);
        for (Line line : lines) {
            String lineImage = line.getLineImage();
            String imgPath = imgUtilService.getImgPath(lineImage);
            line.setLineImage(imgPath);
        }
        return lines;
    }

    @Override
    public Line getLineByLineId(Integer lineId) {
        Line line = lineMapper.selectByPrimaryKey(lineId);
        line.setLineImage(imgUtilService.getImgPath(line.getLineImage()));
        return line;
    }

    @Override
    public int updateLineByLineId(Integer lineId, String lineLevel, String lineName, String lineType, String startPlace, String endPlace, Integer day, BigDecimal price1, BigDecimal price2, Integer qp, Integer dp, String meetPlace, String meetPhone, String goTransport, String backTransport, String lineImage, String linePhone, Integer status, String djs, String bak, String weblog) {
        Line line = lineMapper.selectByPrimaryKey(lineId);
        if (line == null){
            return -1;
        } else {
            String[] split = lineImage.split("/");
            if (!split[split.length-1].equals(line.getLineImage())){
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

    @Override
    public Line getLineByLineName(String lineName) {
        Line line = lineMapper.selectLineByLineName(lineName);
        line.setLineImage(imgUtilService.getImgPath(line.getLineImage()));
        return line;
    }
}
