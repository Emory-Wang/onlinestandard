package com.project.mapper;

import com.project.entity.Equipment;
import com.project.entity.ItemProperty;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface itemPropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemProperty record);

    int insertSelective(ItemProperty record);

    ItemProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemProperty record);

    int updateByPrimaryKey(ItemProperty record);

    public List<Equipment> findAllEquips(int id);

    public List<ItemProperty> findAll(int itemId);

    public int deleteByItemId(int id);
}