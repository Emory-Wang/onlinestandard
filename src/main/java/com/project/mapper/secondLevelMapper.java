package com.project.mapper;

import com.project.entity.SecondLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface secondLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecondLevel record);

    SecondLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(SecondLevel record);

    List<SecondLevel> selectByFirstLevel(Integer id);

    List<SecondLevel> selectAll();
}