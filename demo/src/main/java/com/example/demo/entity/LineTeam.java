package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LineTeam {
    private Integer lineteamId;

    private Integer teamId;

    private Integer lineId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date goDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date backDate;

    private Integer adult;

    private Integer child;

    public LineTeam(Integer lineteamId, Integer teamId, Integer lineId, Date goDate, Date backDate, Integer adult, Integer child) {
        this.lineteamId = lineteamId;
        this.teamId = teamId;
        this.lineId = lineId;
        this.goDate = goDate;
        this.backDate = backDate;
        this.adult = adult;
        this.child = child;
    }

    public LineTeam() {
        super();
    }

    public Integer getLineteamId() {
        return lineteamId;
    }

    public void setLineteamId(Integer lineteamId) {
        this.lineteamId = lineteamId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public Date getGoDate() {
        return goDate;
    }

    public void setGoDate(Date goDate) {
        this.goDate = goDate;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }

    public Integer getAdult() {
        return adult;
    }

    public void setAdult(Integer adult) {
        this.adult = adult;
    }

    public Integer getChild() {
        return child;
    }

    public void setChild(Integer child) {
        this.child = child;
    }
}