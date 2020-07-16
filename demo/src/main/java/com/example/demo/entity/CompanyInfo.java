package com.example.demo.entity;

public class CompanyInfo {
    private Integer companyId;

    private String companyName;

    private String keywords;

    private Integer phone;

    private String address;

    private String about;

    public CompanyInfo(Integer companyId, String companyName, String keywords, Integer phone, String address, String about) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.keywords = keywords;
        this.phone = phone;
        this.address = address;
        this.about = about;
    }

    public CompanyInfo() {
        super();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about == null ? null : about.trim();
    }
}