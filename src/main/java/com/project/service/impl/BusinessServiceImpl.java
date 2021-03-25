package com.project.service.impl;

import com.project.entity.Business;
import com.project.mapper.businessMapper;
import com.project.mapper.cityMapper;
import com.project.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements IBusinessService {
    @Autowired
    private businessMapper BusinessMapper;

    @Override
    public List<Business> getBusiness() {
        return BusinessMapper.getBusiness();
    }

    @Override
    public int getBusinessId(String name) {
        return BusinessMapper.getBusinessId(name);
    }
}
