package com.project.mapper;

import com.project.entity.Business;
import com.project.entity.Standard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface businessMapper {
    int getBusinessId(String name);
    List<Business> getBusiness();
}
