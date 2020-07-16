package com.example.demo.controller;

import com.example.demo.entity.CompanyInfo;
import com.example.demo.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private CompanyInfoService companyInfoService;

    //获取公司信息
    @RequestMapping("/company")
    public Map<String,Object> getCompanyInfo() {
        Map<String,Object> map = new HashMap<>();
        CompanyInfo companyInfo = companyInfoService.selectCompanyInfoByCompanyId(1);
        if (companyInfo!=null){
            map.put("code",0);
            map.put("msg","公司信息获取成功");
            map.put("companyInfo",companyInfo);
        } else {
            map.put("code",-1);
            map.put("msg","公司信息获取失败");
        }
        return map;
    }
}
