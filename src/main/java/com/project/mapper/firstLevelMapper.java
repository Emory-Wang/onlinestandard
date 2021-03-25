package com.project.mapper;

import com.alibaba.fastjson.JSONObject;
import com.project.entity.City;
import com.project.entity.FirstLevel;
import com.project.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface firstLevelMapper {
    List<FirstLevel> findThree(Integer template_id);

    List<FirstLevel> findThreeByStandard(Integer standard_id);

    List<Item> findItems();

    List<JSONObject> findItemEquip(Integer item_id,Integer standard_id);

    List<JSONObject> findStandardInfo(Integer standard_id);

    List<JSONObject> findEquipInfo(Integer standard_id);

    List<JSONObject> findFirstLevel();

    List<FirstLevel> findAll();

    int deleteByPrimaryKey(Integer id);

    int insert(FirstLevel record);

    FirstLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(FirstLevel record);


}
