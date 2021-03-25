package com.project.service;

import com.project.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ICityService {

    //查询所有
    public List<City> findAll();
    public List<City> findProvince(Integer id);
}
