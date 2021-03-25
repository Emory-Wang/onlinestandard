package com.project.service;

import com.project.entity.Equipment;
import com.project.entity.Property;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPropertyService {
    public List<Property> findAll(int id);


    public int insert(Property property);

    public int update(Property property);

    public int delete(int id);

    public Property select(int id);
}
