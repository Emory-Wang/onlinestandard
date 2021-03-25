package com.project.service.impl;

import com.project.entity.City;
import com.project.entity.StandardItem;
import com.project.mapper.cityMapper;
import com.project.mapper.standardItemMapper;
import com.project.service.ICityService;
import com.project.service.IStandardItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardItemServiceImpl implements IStandardItemService {

    @Autowired
    private standardItemMapper StandardItemMapper;

    @Override
    public int insertOne(StandardItem standardItem) {
        return StandardItemMapper.insertOne(standardItem);
    }

    @Override
    public int insertMulti(List<StandardItem> standardItems) {
        return StandardItemMapper.insertMulti(standardItems);
    }

    @Override
    public void delete(Integer id) {
        StandardItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<StandardItem> findRequired(Integer standardId, Integer itemId) {
        return StandardItemMapper.findRequired(standardId,itemId);
    }

    @Override
    public void edit(StandardItem standardItem) {
        StandardItemMapper.edit(standardItem);
    }
}
