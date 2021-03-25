package com.project.controller;

import com.project.entity.Equipment;
import com.project.entity.Property;
import com.project.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Property")
public class PropertyController {
    @Autowired
    private IPropertyService iPropertyService;

    //根据equip_id查询Property  要求传入参数为equip_id  标准属性管理界面在选择完设备后根据选择的设备id为设备属性下拉框赋值
    @GetMapping("/findAll")
    public List<Property> findAll(@RequestParam("equip_id") String id){
        return iPropertyService.findAll(Integer.parseInt(id));
    }


    @PostMapping("/insert")
    public int insert(@RequestBody Property property){
        return iPropertyService.insert(property);
    }

    @PostMapping("/edit")
    public int update(@RequestBody Property property){
        return iPropertyService.update(property);
    }

    @PostMapping("/delete")
    public int delete(@RequestBody Property property){
        return iPropertyService.delete(property.getId());
    }

    @PostMapping("/multipleDelete")
    public int mulDelete(@RequestBody String[] ids){
        for(String id:ids){//批量删除调试
            iPropertyService.delete(Integer.parseInt(id));
        }
        return 1;
    }

}
