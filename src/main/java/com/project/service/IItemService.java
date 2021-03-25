package com.project.service;

import com.project.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IItemService {
    public List<Item> findAll();

    public List<Item> findItemWithoutEquip();

    public int insert(Item item);

    public int update(Item item);

    public int delete(int id);

    public Item select(int id);
}
