package com.project.mapper;

import com.project.entity.City;
import com.project.entity.StandardItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface standardItemMapper {
    int insertOne(StandardItem standardItem);
    int insertMulti(List<StandardItem> standardItems);
    int deleteByPrimaryKey(Integer id);
    List<StandardItem> findRequired(Integer standardId,Integer itemId);
    void edit(StandardItem standardItem);
}
