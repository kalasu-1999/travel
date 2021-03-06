package com.example.demo.mapper;

import com.example.demo.entity.Message;
import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    Message selectByPrimaryKey(Integer messageId);

    List<Message> selectAll();

    int updateByPrimaryKey(Message record);

    //根据用户id获取留言信息按留言id降序排序
    List<Message> selectMessageByGuestId(Integer guestId);
}