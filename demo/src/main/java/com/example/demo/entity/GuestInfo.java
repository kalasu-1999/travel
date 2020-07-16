package com.example.demo.entity;

public class GuestInfo {
    private Integer id;

    private Integer guestId;

    private String address;

    private String phone;

    private String email;

    public GuestInfo(Integer id, Integer guestId, String address, String phone, String email) {
        this.id = id;
        this.guestId = guestId;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public GuestInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}