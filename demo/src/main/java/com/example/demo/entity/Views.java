package com.example.demo.entity;

public class Views {
    private Integer viewId;

    private String viewName;

    private String viewImage;

    private String content;

    public Views(Integer viewId, String viewName, String viewImage, String content) {
        this.viewId = viewId;
        this.viewName = viewName;
        this.viewImage = viewImage;
        this.content = content;
    }

    public Views() {
        super();
    }

    public Integer getViewId() {
        return viewId;
    }

    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName == null ? null : viewName.trim();
    }

    public String getViewImage() {
        return viewImage;
    }

    public void setViewImage(String viewImage) {
        this.viewImage = viewImage == null ? null : viewImage.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}