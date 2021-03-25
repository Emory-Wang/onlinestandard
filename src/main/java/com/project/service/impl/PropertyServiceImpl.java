package com.project.service.impl;

import com.project.entity.Property;
import com.project.mapper.propertyMapper;
import com.project.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements IPropertyService {
    @Autowired
    private propertyMapper PropertyMapper;

    @Override
    public List<Property> findAll(int id) {
        return PropertyMapper.findAll(id);
    }

    @Override
    public int insert(Property property) {
        return PropertyMapper.insert(property);
    }

    @Override
    public int update(Property property) {
        return PropertyMapper.updateByPrimaryKey(property);
    }

    @Override
    public int delete(int id) {
        return PropertyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Property select(int id) {
        return PropertyMapper.selectByPrimaryKey(id);
    }
}
