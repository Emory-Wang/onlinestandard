package com.project.service.impl;

import com.project.entity.Equipment;
import com.project.entity.ItemProperty;
import com.project.mapper.itemPropertyMapper;
import com.project.service.IItemPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPropertyServiceImpl implements IItemPropertyService {
    @Autowired
    private itemPropertyMapper ItemPropertyMapper;
    @Override
    public List<Equipment> findAllEquips(int id) {
        return ItemPropertyMapper.findAllEquips(id);
    }

    @Override
    public int insert(ItemProperty itemProperty) {
        return ItemPropertyMapper.insert(itemProperty);
    }

    @Override
    public int delete(int itemId) {
        return ItemPropertyMapper.deleteByItemId(itemId);
    }

    @Override
    public List<ItemProperty> findAll(int itemId) {
        return ItemPropertyMapper.findAll(itemId);
    }
}
