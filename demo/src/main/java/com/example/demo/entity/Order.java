package com.example.demo.entity;

public class Order {
    private Integer orderId;

    private Integer guestId;

    private Integer lineteamId;

    private Integer adult;

    private Integer child;

    private Integer tag;

    private String bak;

    public Order(Integer orderId, Integer guestId, Integer lineteamId, Integer adult, Integer child, Integer tag, String bak) {
        this.orderId = orderId;
        this.guestId = guestId;
        this.lineteamId = lineteamId;
        this.adult = adult;
        this.child = child;
        this.tag = tag;
        this.bak = bak;
    }

    public Order() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public Integer getLineteamId() {
        return lineteamId;
    }

    public void setLineteamId(Integer lineteamId) {
        this.lineteamId = lineteamId;
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

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak == null ? null : bak.trim();
    }
}