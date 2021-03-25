package com.project.service;

import com.project.entity.Equipment;
import com.project.entity.ItemProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IItemPropertyService {

    public List<Equipment> findAllEquips(int id);

    public int insert(ItemProperty itemProperty);

    public int delete(int itemId);

    public List<ItemProperty> findAll(int itemId);

}
