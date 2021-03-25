package com.project.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.project.entity.City;
import com.project.entity.Standard;
import com.project.mapper.standardMapper;
import com.project.service.IStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StandardServiceImpl implements IStandardService {

    @Autowired
    private standardMapper StandardMapper;


    @Override
    public List<Standard> findAllStandard() {
        return StandardMapper.findAllStandard();
    }
    @Override
    public List<Standard> findAllStandardForm() {
        return StandardMapper.findAllStandardForm();
    }

    @Override
    public List<JSONObject> findStandardById(Integer standard_id) {
        return StandardMapper.findStandardById(standard_id);
    }

    @Override
    public void edit(Standard standard) {
        StandardMapper.updateByPrimaryKeySelective(standard);
    }

    @Override
    public void delete(Integer id) {
        StandardMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(Standard standard) {
        StandardMapper.insertSelective(standard);
    }
}
