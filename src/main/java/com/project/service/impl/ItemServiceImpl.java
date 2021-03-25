package com.project.service.impl;

import com.project.entity.Item;
import com.project.mapper.itemMapper;
import com.project.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {
    @Autowired
    private itemMapper ItemMapper;

    @Override
    public List<Item> findAll() {
        return ItemMapper.findAll();
    }

    @Override
    public List<Item> findItemWithoutEquip() {
        return ItemMapper.findItemWithoutEquip();
    }

    @Override
    public int insert(Item item) {
        ItemMapper.insert(item);
        return item.getId();
    }

    @Override
    public int update(Item item) {
        return ItemMapper.updateByPrimaryKey(item);
    }

    @Override
    public int delete(int id) {
        return ItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Item select(int id) {
        return ItemMapper.selectByPrimaryKey(id);
    }
}
