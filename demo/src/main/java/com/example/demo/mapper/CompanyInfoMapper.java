package com.example.demo.mapper;

import com.example.demo.entity.CompanyInfo;
import java.util.List;

public interface CompanyInfoMapper {
    int deleteByPrimaryKey(Integer companyId);

    int insert(CompanyInfo record);

    CompanyInfo selectByPrimaryKey(Integer companyId);

    List<CompanyInfo> selectAll();

    int updateByPrimaryKey(CompanyInfo record);
}