package com.example.demo.service;

import com.example.demo.entity.CompanyInfo;

public interface CompanyInfoService {
    //获取公司信息
    CompanyInfo selectCompanyInfoByCompanyId(Integer companyId);
}
