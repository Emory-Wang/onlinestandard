package com.project.controller;

import com.project.entity.Equipment;
import com.project.entity.Item;
import com.project.entity.ItemProperty;
import com.project.service.IItemPropertyService;
import com.project.service.IItemService;
import com.project.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Item")
public class ItemController {
    @Autowired
    private IItemService iItemService;

    @Autowired
    private IItemPropertyService iItemPropertyService;

    @Autowired
    private IPropertyService iPropertyService;

    @GetMapping("/findAll")
    public List<Item> findAll(){
        List<Item> itemList = iItemService.findAll();
        for(Item item:itemList){
            if(item.getProperty_related()){
                List<Equipment> equipmentList = iItemPropertyService.findAllEquips(item.getId());
                String equips = "";
                for(Equipment equipment:equipmentList){
                    equips += equipment.getEquip_name() + "、";
                }
                item.setEquips(equips);
            }
        }
        return itemList;
    }

    @PostMapping("/insert")
    public int insert(@RequestBody Item item){
        //System.out.println(item);
        int id = iItemService.insert(item);
        if(item.getProperty_related()){
            int[][] properties = item.getProperties();
            for(int i = 0;i < properties.length;i++){
                ItemProperty itemProperty = new ItemProperty();
                itemProperty.setItem_id(id);
                itemProperty.setProperty_id(properties[i][1]);
                iItemPropertyService.insert(itemProperty);
            }
        }

        return 1;
    }

    @PostMapping("/edit")
    public int update(@RequestBody Item item){
        //System.out.println(item);
        iItemService.update(item);
        if(item.getProperty_related()){
            int[][] properties = item.getProperties();
            iItemPropertyService.delete(item.getId());
            for(int i = 0;i < properties.length;i++){
                ItemProperty itemProperty = new ItemProperty();
                itemProperty.setItem_id(item.getId());
                itemProperty.setProperty_id(properties[i][1]);
                iItemPropertyService.insert(itemProperty);
            }
        }else{
            iItemPropertyService.delete(item.getId());
        }
        return 1;
    }

    @GetMapping("/delete")
    public int delete(@RequestParam("id")String idp){
        iItemService.delete(Integer.parseInt(idp));
        iItemPropertyService.delete(Integer.parseInt(idp));
        return 1;
    }

    @GetMapping("/queryItem")
    public Item selectOne(@RequestParam("id")String idp){
        Item item = iItemService.select(Integer.parseInt(idp));
        if(item.getProperty_related()){
            List<ItemProperty> propertyList = iItemPropertyService.findAll(item.getId());
            int[][] properties = new int[propertyList.size()][2];
            for(int i = 0;i < propertyList.size();i++){
                int proper_id = propertyList.get(i).getProperty_id();
                int equip_id = iPropertyService.select(proper_id).getEquip_id();
                properties[i][0] = equip_id;
                properties[i][1] = proper_id;
            }
            item.setProperties(properties);
        }
        return item;
    }

}
