package com.project.mapper;

import com.project.entity.FirstLevel;
import com.project.entity.SecondLevel;
import com.project.entity.TemplateLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface templateLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TemplateLevel record);

    int insertSelective(TemplateLevel record);

    TemplateLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TemplateLevel record);

    int updateByPrimaryKey(TemplateLevel record);

    List<TemplateLevel> selectByTempId(Integer tempId);

    List<FirstLevel> findThree(int tempId);

    List<FirstLevel> findFirstRemainder(List<TemplateLevel> tlList);

    List<SecondLevel> findSecondRemainder(@Param("firstId") int firstId, @Param("list") List<TemplateLevel> tlList);

    int deleteSecondLevel(@Param("tempId") int tempId, @Param("secondId") int secondId);

    int deleteFirstLevel(@Param("tempId")int tempId, @Param("list")List<SecondLevel> secondLevels);
}