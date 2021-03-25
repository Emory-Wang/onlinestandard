package com.project.mapper;

import com.project.entity.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface cityMapper {
    List<City> findAll();
    List<City> findProvince(Integer id);
}
