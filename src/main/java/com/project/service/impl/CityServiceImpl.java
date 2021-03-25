package com.project.service.impl;

import com.project.entity.City;
import com.project.mapper.cityMapper;
import com.project.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    @Autowired
    private cityMapper CityMapper;


    @Override
    public List<City> findAll() {
        return CityMapper.findAll();
    }

    @Override
    public List<City> findProvince(Integer id) {
        return CityMapper.findProvince(id);
    }
}
