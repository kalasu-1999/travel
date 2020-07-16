package com.example.demo.entity;

import java.util.Date;

public class News {
    private Integer newsId;

    private String title;

    private String show;

    private Date time;

    private String delfig;

    public News(Integer newsId, String title, String show, Date time, String delfig) {
        this.newsId = newsId;
        this.title = title;
        this.show = show;
        this.time = time;
        this.delfig = delfig;
    }

    public News() {
        super();
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show == null ? null : show.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDelfig() {
        return delfig;
    }

    public void setDelfig(String delfig) {
        this.delfig = delfig == null ? null : delfig.trim();
    }
}