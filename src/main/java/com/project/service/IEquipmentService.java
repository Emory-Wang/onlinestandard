package com.project.service;

import com.project.entity.Equipment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEquipmentService {
    //查询所有
    public List<Equipment> findAll();

    public List<Equipment> findByItem(Integer item_id);

    public int insert(Equipment equipment);

    public int update(Equipment equipment);

    public int delete(int id);
}
