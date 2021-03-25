package com.project.mapper;

import com.project.entity.City;
import com.project.entity.Template;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface templateMapper {
    List<Template> findAll();

    int deleteByPrimaryKey(Integer id);

    int insert(Template record);

    Template selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Template record);

}
