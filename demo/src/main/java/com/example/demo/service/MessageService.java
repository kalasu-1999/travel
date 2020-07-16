package com.example.demo.service;

import com.example.demo.entity.Message;
import com.github.pagehelper.Page;

public interface MessageService {
    //添加留言
    int insertMessage(Integer guestId, String title, String content);
    //查询全部留言，按留言id倒序排列
    Page<Message> selectAllMessage();
    //根据留言id删除留言
    int deleteMessage(Integer messageId);
    //查看用户自己的留言，按留言id倒序排序
    Page<Message> selectMessageByGuestId(Integer guestId);
}
