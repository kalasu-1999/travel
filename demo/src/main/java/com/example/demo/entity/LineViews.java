package com.example.demo.entity;

public class LineViews {
    private Integer lineviewsId;

    private Integer lineId;

    private Integer viewId;

    public LineViews(Integer lineviewsId, Integer lineId, Integer viewId) {
        this.lineviewsId = lineviewsId;
        this.lineId = lineId;
        this.viewId = viewId;
    }

    public LineViews() {
        super();
    }

    public Integer getLineviewsId() {
        return lineviewsId;
    }

    public void setLineviewsId(Integer lineviewsId) {
        this.lineviewsId = lineviewsId;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public Integer getViewId() {
        return viewId;
    }

    public void setViewId(Integer viewId) {
        this.viewId = viewId;
    }
}