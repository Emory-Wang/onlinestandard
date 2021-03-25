package com.project.service;

import com.alibaba.fastjson.JSONObject;
import com.project.entity.City;
import com.project.entity.FirstLevel;
import com.project.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IFirstLevelService {

    //查询所有
    public List<FirstLevel> findThree(Integer id);

    public List<FirstLevel> findThreeByStandard(Integer id);


    //查询item
    public List<Item> findItems();

    public List<JSONObject> findItemEquip(Integer item_id,Integer standard_id);

    public List<JSONObject> findStandardInfo(Integer standard_id);

    public List<JSONObject> findEquipInfo(Integer standard_id);

    public List<JSONObject> findFirstLevel();

    //查询一级分类列表
    public List<FirstLevel> findAll();

    public int insert(FirstLevel firstLevel);

    public int update(FirstLevel firstLevel);

    public int delete(int id);
}
