package com.example.demo.entity;

public class Team {
    private Integer teamId;

    private Integer companyId;

    private String guide1;

    private String guide2;

    private String phone;

    private String bak;

    public Team(Integer teamId, Integer companyId, String guide1, String guide2, String phone, String bak) {
        this.teamId = teamId;
        this.companyId = companyId;
        this.guide1 = guide1;
        this.guide2 = guide2;
        this.phone = phone;
        this.bak = bak;
    }

    public Team() {
        super();
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getGuide1() {
        return guide1;
    }

    public void setGuide1(String guide1) {
        this.guide1 = guide1 == null ? null : guide1.trim();
    }

    public String getGuide2() {
        return guide2;
    }

    public void setGuide2(String guide2) {
        this.guide2 = guide2 == null ? null : guide2.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak == null ? null : bak.trim();
    }
}