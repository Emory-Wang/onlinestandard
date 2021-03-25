package com.project.service;

import com.alibaba.fastjson.JSONObject;
import com.project.entity.City;
import com.project.entity.Standard;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IStandardService {

    //查询所有
    public List<Standard> findAllStandard();
    public List<Standard> findAllStandardForm();
    public List<JSONObject> findStandardById(Integer standard_id);
    public void edit(Standard standard);
    public void delete(Integer id);
    public void insert(Standard standard);
}
