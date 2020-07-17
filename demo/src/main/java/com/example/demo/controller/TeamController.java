package com.example.demo.controller;

import com.example.demo.entity.CompanyInfo;
import com.example.demo.entity.Team;
import com.example.demo.service.CompanyInfoService;
import com.example.demo.service.TeamService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private TeamService teamService;

    //获取公司信息
    @RequestMapping("/company")
    public Map<String, Object> getCompanyInfo() {
        Map<String, Object> map = new HashMap<>();
        CompanyInfo companyInfo = companyInfoService.selectCompanyInfoByCompanyId(1);
        if (companyInfo != null) {
            map.put("code", 0);
            map.put("msg", "公司信息获取成功");
            map.put("data", companyInfo);
        } else {
            map.put("code", -1);
            map.put("msg", "公司信息获取失败");
        }
        return map;
    }

    //多条件查询
    @RequestMapping("/selectTeamByMore")
    public Map<String, Object> selectTeamByMore(Integer teamId, Integer companyId, String guide1, String guide2, String phone, String bak, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, size);
        List<Team> teams = teamService.selectTeamByMore(teamId, companyId, guide1, guide2, phone, bak);
        if (teams.isEmpty()) {
            map.put("code", -1);
            map.put("msg", "旅行团信息获取失败或未能找到符合的旅行团");
        } else {
            PageInfo<Team> teamList = new PageInfo<>(teams);
            map.put("code", 0);
            map.put("msg", "旅行团信息获取成功");
            map.put("data", teamList);
        }
        return map;
    }

    //根据旅行团id修改旅行团信息
    @RequestMapping("/updateTeamByTeamId")
    public Map<String, Object> updateTeamByTeamId(String guide1, String guide2, String phone, String bak) {
        Map<String, Object> map = new HashMap<>();
        if (teamService.updateTeamByTeamId(guide1, guide2, phone, bak) == 1) {
            map.put("code", 0);
            map.put("msg", "旅行团信息修改成功");
        } else {
            map.put("code", -1);
            map.put("msg", "旅行团信息修改失败");
        }
        return map;
    }

    //添加旅行团信息
    @RequestMapping("/insertTeam")
    public Map<String, Object> insertTeam(String guide1, String guide2, String phone, String bak) {
        Map<String, Object> map = new HashMap<>();
        if (teamService.insertTeam(guide1, guide2, phone, bak) == 1) {
            map.put("code", 0);
            map.put("msg", "旅行团信息修改成功");
        } else {
            map.put("code", -1);
            map.put("msg", "旅行团信息修改失败");
        }
        return map;
    }

    //获取全部旅行团信息
    @RequestMapping("/getAllTeams")
    public Map<String, Object> getAllTeams(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(page, size);
        Page<Team> teams = teamService.selectAllTeam();
        if (teams.isEmpty()) {
            map.put("code", -1);
            map.put("msg", "旅行团信息获取失败");
        } else {
            map.put("code", 0);
            map.put("msg", "旅行团信息获取成功");
            map.put("data", teams);
        }
        return map;
    }

    //根据id获取信息
    @RequestMapping("/selectTeamByTeamId")
    public Map<String, Object> selectTeamByTeamId(Integer teamId) {
        Map<String, Object> map = new HashMap<>();
        Team team = teamService.selectTeamByTeamId(teamId);
        if (team == null) {
            map.put("code", -1);
            map.put("msg", "旅行团信息获取失败");
        } else {
            map.put("code", 0);
            map.put("msg", "旅行团信息获取成功");
            map.put("data", team);
        }
        return map;
    }
}
