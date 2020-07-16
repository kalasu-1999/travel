package com.example.demo.service.impl;

import com.example.demo.entity.Message;
import com.example.demo.mapper.GuestMapper;
import com.example.demo.mapper.MessageMapper;
import com.example.demo.service.MessageService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private GuestMapper guestMapper;

    @Override
    public int insertMessage(Integer guestId, String title, String content) {
        return messageMapper.insert(new Message(null,guestId,title,content));
    }

    @Override
    public List<Map<String,Object>> selectAllMessage() {
        List<Message> messages = messageMapper.selectAll();
        List<Map<String,Object>> messageList = new ArrayList<>();
        for (Message message : messages) {
            Map<String,Object> map = new HashMap<>();
            map.put("messageId",message.getMessageId());
            map.put("guestName",guestMapper.selectByPrimaryKey(message.getGuestId()).getName());
            map.put("title",message.getTitle());
            map.put("content",message.getContent());
            messageList.add(map);
        }
        return messageList;
    }

    @Override
    public int deleteMessage(Integer messageId) {
        return messageMapper.deleteByPrimaryKey(messageId);
    }

    @Override
    public List<Map<String,Object>> selectMessageByGuestId(Integer guestId) {
        List<Message> messages = messageMapper.selectMessageByGuestId(guestId);
        String name = guestMapper.selectByPrimaryKey(guestId).getName();
        List<Map<String,Object>> messageList = new ArrayList<>();
        for (Message message : messages) {
            Map<String,Object> map = new HashMap<>();
            map.put("messageId",message.getMessageId());
            map.put("guestName",name);
            map.put("title",message.getTitle());
            map.put("content",message.getContent());
            messageList.add(map);
        }
        return messageList;
    }
}
