package com.example.demo.entity;

import java.math.BigDecimal;

public class Line {
    private Integer lineId;

    private String lineLevel;

    private String lineName;

    private String lineType;

    private String startPlace;

    private String endPlace;

    private Integer day;

    private BigDecimal price1;

    private BigDecimal price2;

    private Integer qp;

    private Integer dp;

    private String meetPlace;

    private String meetPhone;

    private String goTransport;

    private String backTransport;

    private String lineImage;

    private String linePhone;

    private Integer status;

    private String djs;

    private String bak;

    private String weblog;

    public Line(Integer lineId, String lineLevel, String lineName, String lineType, String startPlace, String endPlace, Integer day, BigDecimal price1, BigDecimal price2, Integer qp, Integer dp, String meetPlace, String meetPhone, String goTransport, String backTransport, String lineImage, String linePhone, Integer status, String djs, String bak, String weblog) {
        this.lineId = lineId;
        this.lineLevel = lineLevel;
        this.lineName = lineName;
        this.lineType = lineType;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.day = day;
        this.price1 = price1;
        this.price2 = price2;
        this.qp = qp;
        this.dp = dp;
        this.meetPlace = meetPlace;
        this.meetPhone = meetPhone;
        this.goTransport = goTransport;
        this.backTransport = backTransport;
        this.lineImage = lineImage;
        this.linePhone = linePhone;
        this.status = status;
        this.djs = djs;
        this.bak = bak;
        this.weblog = weblog;
    }

    public Line() {
        super();
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getLineLevel() {
        return lineLevel;
    }

    public void setLineLevel(String lineLevel) {
        this.lineLevel = lineLevel == null ? null : lineLevel.trim();
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName == null ? null : lineName.trim();
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType == null ? null : lineType.trim();
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace == null ? null : startPlace.trim();
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace == null ? null : endPlace.trim();
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public BigDecimal getPrice1() {
        return price1;
    }

    public void setPrice1(BigDecimal price1) {
        this.price1 = price1;
    }

    public BigDecimal getPrice2() {
        return price2;
    }

    public void setPrice2(BigDecimal price2) {
        this.price2 = price2;
    }

    public Integer getQp() {
        return qp;
    }

    public void setQp(Integer qp) {
        this.qp = qp;
    }

    public Integer getDp() {
        return dp;
    }

    public void setDp(Integer dp) {
        this.dp = dp;
    }

    public String getMeetPlace() {
        return meetPlace;
    }

    public void setMeetPlace(String meetPlace) {
        this.meetPlace = meetPlace == null ? null : meetPlace.trim();
    }

    public String getMeetPhone() {
        return meetPhone;
    }

    public void setMeetPhone(String meetPhone) {
        this.meetPhone = meetPhone == null ? null : meetPhone.trim();
    }

    public String getGoTransport() {
        return goTransport;
    }

    public void setGoTransport(String goTransport) {
        this.goTransport = goTransport == null ? null : goTransport.trim();
    }

    public String getBackTransport() {
        return backTransport;
    }

    public void setBackTransport(String backTransport) {
        this.backTransport = backTransport == null ? null : backTransport.trim();
    }

    public String getLineImage() {
        return lineImage;
    }

    public void setLineImage(String lineImage) {
        this.lineImage = lineImage == null ? null : lineImage.trim();
    }

    public String getLinePhone() {
        return linePhone;
    }

    public void setLinePhone(String linePhone) {
        this.linePhone = linePhone == null ? null : linePhone.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDjs() {
        return djs;
    }

    public void setDjs(String djs) {
        this.djs = djs == null ? null : djs.trim();
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak == null ? null : bak.trim();
    }

    public String getWeblog() {
        return weblog;
    }

    public void setWeblog(String weblog) {
        this.weblog = weblog == null ? null : weblog.trim();
    }
}