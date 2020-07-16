package com.example.demo.service.impl;

import com.example.demo.entity.CompanyInfo;
import com.example.demo.mapper.CompanyInfoMapper;
import com.example.demo.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {
    @Autowired
    private CompanyInfoMapper companyInfoMapper;

    //获取公司信息
    @Override
    public CompanyInfo selectCompanyInfoByCompanyId(Integer companyId) {
        return companyInfoMapper.selectByPrimaryKey(companyId);
    }
}
