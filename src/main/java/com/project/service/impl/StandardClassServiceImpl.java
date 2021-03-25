package com.project.service.impl;

import com.project.entity.Business;
import com.project.entity.StandardClass;
import com.project.mapper.businessMapper;
import com.project.mapper.standardClassMapper;
import com.project.service.IBusinessService;
import com.project.service.IStandardClassService;
import com.project.service.IStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardClassServiceImpl implements IStandardClassService {
    @Autowired
    private standardClassMapper StandardClassmapper;

    @Override
    public List<StandardClass> findAll() {
        return StandardClassmapper.findAll();
    }
}
