package com.example.demo.entity;

public class Guest {
    private Integer guestId;

    private String name;

    private String password;

    private Integer flag;

    public Guest(Integer guestId, String name, String password, Integer flag) {
        this.guestId = guestId;
        this.name = name;
        this.password = password;
        this.flag = flag;
    }

    public Guest() {
        super();
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}