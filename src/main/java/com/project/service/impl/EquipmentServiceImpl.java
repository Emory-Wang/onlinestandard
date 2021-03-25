package com.project.service.impl;

import com.project.entity.Equipment;
import com.project.service.IEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements IEquipmentService {
    @Autowired
    private com.project.mapper.equipmentMapper equipmentMapper;

    @Override
    public List<Equipment> findAll() {
        return equipmentMapper.findAll();
    }

    @Override
    public List<Equipment> findByItem(Integer item_id) {
        return equipmentMapper.findByItem(item_id);
    }

    @Override
    public int insert(Equipment equipment) {
        return equipmentMapper.insert(equipment);
    }

    @Override
    public int update(Equipment equipment) {
        return equipmentMapper.updateByPrimaryKey(equipment);
    }

    @Override
    public int delete(int id) {
        return equipmentMapper.deleteByPrimaryKey(id);
    }
}
