package com.project.mapper;

import com.project.entity.Equipment;
import com.project.entity.Property;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface propertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Property record);

    int insertSelective(Property record);

    Property selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);

    List<Property> findAll(Integer id);

    List<Property> findByEquip(Integer equip_id);
}
