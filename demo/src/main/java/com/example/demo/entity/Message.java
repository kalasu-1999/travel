package com.example.demo.entity;

public class Message {
    private Integer messageId;

    private Integer guestId;

    private String title;

    private String content;

    public Message(Integer messageId, Integer guestId, String title, String content) {
        this.messageId = messageId;
        this.guestId = guestId;
        this.title = title;
        this.content = content;
    }

    public Message() {
        super();
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}