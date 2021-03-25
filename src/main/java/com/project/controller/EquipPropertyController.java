package com.project.controller;

import com.project.entity.EquipProperty;
import com.project.entity.Equipment;
import com.project.entity.Property;
import com.project.service.IEquipmentService;
import com.project.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Cascader")
public class EquipPropertyController {
    //设备和属性级联菜单
    @Autowired
    private IEquipmentService iEquipmentService;

    @Autowired
    private IPropertyService iPropertyService;

    @GetMapping
    public List<EquipProperty> get(){
        List<EquipProperty> equipPropertyList = new ArrayList<>();
        List<Equipment> equipmentList = iEquipmentService.findAll();
        for(int i = 0;i < equipmentList.size();i++){
            List<Property> properties = iPropertyService.findAll(equipmentList.get(i).getId());
            EquipProperty equipProperty = new EquipProperty();
            equipProperty.setValue(equipmentList.get(i).getId());
            equipProperty.setLabel(equipmentList.get(i).getEquip_name());
            List<EquipProperty> equipPropertyList1 = new ArrayList<>();
            for(Property property:properties){
                EquipProperty equipProperty1 = new EquipProperty();
                equipProperty1.setValue(property.getId());
                equipProperty1.setLabel(property.getName());
                equipPropertyList1.add(equipProperty1);
            }
            equipProperty.setChildren(equipPropertyList1);
            equipPropertyList.add(equipProperty);
        }
        return equipPropertyList;
    }
}
