package com.example.demo.service.impl;

import com.example.demo.entity.Message;
import com.example.demo.mapper.MessageMapper;
import com.example.demo.service.MessageService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public int insertMessage(Integer guestId, String title, String content) {
        return messageMapper.insert(new Message(null,guestId,title,content));
    }

    @Override
    public Page<Message> selectAllMessage() {
        return (Page<Message>) messageMapper.selectAll();
    }

    @Override
    public int deleteMessage(Integer messageId) {
        return messageMapper.deleteByPrimaryKey(messageId);
    }

    @Override
    public Page<Message> selectMessageByGuestId(Integer guestId) {
        return (Page<Message>) messageMapper.selectMessageByGuestId(guestId);
    }
}
