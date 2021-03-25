package com.project.controller;

import com.project.entity.Equipment;
import com.project.entity.Property;
import com.project.service.IEquipmentService;
import com.project.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equipment")
public class EquipmentController {

    @Autowired
    private IEquipmentService iEquimentService;

    @Autowired
    private IPropertyService iPropertyService;

    @GetMapping("/findAll")
    public List<Equipment> findAll(){
        List<Equipment> list = iEquimentService.findAll();
        for(Equipment equipment:list){
            List<Property> properties = iPropertyService.findAll(equipment.getId());
            String propers = "";
            for(Property property:properties){
                propers += property.getName() + "、";
            }
            equipment.setPropers(propers);
        }
        return list;
    }

    //根据item_id查询Equipment  要求传入参数为item_id  标准属性管理界面加载时调用，为设备下拉框提供数据
    @GetMapping("/findByItem")
    public List<Equipment> findByItem(@RequestParam("item_id") Integer item_id){
        return iEquimentService.findByItem(item_id);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody Equipment equipment){
        return iEquimentService.insert(equipment);
    }

    @PostMapping("/edit")
    public int update(@RequestBody Equipment equipment){
        return iEquimentService.update(equipment);
    }

    @PostMapping("/delete")
    public int delete(@RequestBody Equipment equipment){
        return iEquimentService.delete(equipment.getId());
    }

}
