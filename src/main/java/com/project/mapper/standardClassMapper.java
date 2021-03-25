package com.project.mapper;

import com.project.entity.Business;
import com.project.entity.StandardClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface standardClassMapper {

    List<StandardClass> findAll();
}
