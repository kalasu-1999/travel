package com.example.demo.service;

import java.util.Date;

public interface LineTeamService {
    //添加路线-旅行团对应信息
    int insertLineTeam(Integer teamId, Integer lineId, Date goDate, Date backDate);
    //
}
