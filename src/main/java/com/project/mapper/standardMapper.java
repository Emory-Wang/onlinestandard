package com.project.mapper;

import com.alibaba.fastjson.JSONObject;
import com.project.entity.Standard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface standardMapper {
    List<Standard> findAllStandard();
    List<Standard> findAllStandardForm();
    List<JSONObject> findStandardById(Integer standard_id);
    int updateByPrimaryKeySelective(Standard standard);
    int deleteByPrimaryKey(Integer id);
    int insertSelective(Standard standard);

}
