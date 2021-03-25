package com.project.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.project.entity.City;
import com.project.entity.FirstLevel;
import com.project.entity.Item;
import com.project.mapper.cityMapper;
import com.project.mapper.firstLevelMapper;
import com.project.service.ICityService;
import com.project.service.IFirstLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirstLevelServiceImpl implements IFirstLevelService {

    @Autowired
    private firstLevelMapper FirstLevelMapper;


    @Override
    public List<FirstLevel> findThree(Integer id) {
        return FirstLevelMapper.findThree(id);
    }

    @Override
    public List<FirstLevel> findThreeByStandard(Integer id) {
        return FirstLevelMapper.findThreeByStandard(id);
    }

    @Override
    public List<Item> findItems() {
        return FirstLevelMapper.findItems();
    }

    @Override
    public List<JSONObject> findItemEquip(Integer item_id,Integer standard_id) {
        return FirstLevelMapper.findItemEquip(item_id,standard_id);
    }

    @Override
    public List<JSONObject> findStandardInfo(Integer standard_id) {
        return FirstLevelMapper.findStandardInfo(standard_id);
    }

    @Override
    public List<JSONObject> findEquipInfo(Integer standard_id) {
        return FirstLevelMapper.findEquipInfo(standard_id);
    }

    @Override
    public List<JSONObject> findFirstLevel() {
        return FirstLevelMapper.findFirstLevel();
    }

    @Override
    public List<FirstLevel> findAll() {
        return FirstLevelMapper.findAll();
    }

    @Override
    public int insert(FirstLevel firstLevel) {
        return FirstLevelMapper.insert(firstLevel);
    }

    @Override
    public int update(FirstLevel firstLevel) {
        return FirstLevelMapper.updateByPrimaryKey(firstLevel);
    }

    @Override
    public int delete(int id) {
        return FirstLevelMapper.deleteByPrimaryKey(id);
    }
}
