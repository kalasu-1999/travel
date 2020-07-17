package com.example.demo.service;

import java.util.List;
import java.util.Map;

public interface MessageService {
    //添加留言
    int insertMessage(Integer guestId, String title, String content);

    //查询全部留言，按留言id倒序排列
    List<Map<String, Object>> selectAllMessage();

    //根据留言id删除留言
    int deleteMessage(Integer messageId);

    //查看用户自己的留言，按留言id倒序排序
    List<Map<String, Object>> selectMessageByGuestId(Integer guestId);
}
