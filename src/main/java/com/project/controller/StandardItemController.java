package com.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.project.entity.*;
import com.project.service.ICityService;
import com.project.service.IFirstLevelService;
import com.project.service.IStandardItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/StandardItem")
public class StandardItemController {
    @Autowired
    private IStandardItemService standardItemService;
    @Autowired
    private IFirstLevelService firstLevelService;

    //输入设备参数数值后 点击信息确认按钮调用 插入一条数据
    //必要传入参数：standard_id，item_id，property_related，property_type，value_1，value_2，required
    @PostMapping("/insertOne")
    public Map<String,Object> insertOne(@RequestBody StandardItem standardItem){
        Map<String,Object> map = new HashMap<>();
        try{
            standardItemService.insertOne(standardItem);
            map.put("success",true);
        }catch(Exception e){
            map.put("success",false);
            map.put("message","保存失败");
        }
        return map;
    }

    //选定一个模板 步骤2点击确定按钮后调用  批量插入多条数据
    @PostMapping("/insertMulti1")
    public Map<String,Object> insertMulti1(@RequestBody List<StandardItem> standardItems){
        Map<String,Object> map = new HashMap<>();
        try{
            standardItemService.insertMulti(standardItems);
            map.put("success",true);
        }catch(Exception e){
            map.put("success",false);
            map.put("message","保存失败");
        }
        return map;
    }

    //编辑standard_item
    @PutMapping("/editEquip")
    public Map<String,Object> edit(@RequestBody StandardItem standardItem){
        Map<String,Object> map = new HashMap<>();
        try{
            standardItemService.edit(standardItem);
            map.put("success",true);
        }catch(Exception e){
            map.put("success",false);
            map.put("message","修改失败");
        }
        return map;
    }


    @GetMapping("/insertMulti")
    public Map<String,Object> insertMulti(@RequestParam("standard_id") Integer standard_id,@RequestParam("template_id") Integer id){
        List<FirstLevel> three = firstLevelService.findThree(id);
        List<StandardItem> resultList = new LinkedList<>();
        for(FirstLevel item : three){
            List<SecondLevel> secondLevels = item.getSecondLevels();
            for (SecondLevel secondLevel: secondLevels) {
                List<Item> items1 = secondLevel.getItems();
                for (Item item3:items1) {
                    StandardItem tempobj = new StandardItem();
                    tempobj.setStandard_id(standard_id);
                    tempobj.setItem_id(item3.getId());
                    tempobj.setProperty_related(item3.getProperty_related());
                    tempobj.setRequired(true); //存在问题，通过模板添加的标准项required的值获取方式未知    默认必选
                    resultList.add(tempobj);
                }
            }
        }
        //return resultList;
        Map<String,Object> map = new HashMap<>();
        try{
            standardItemService.insertMulti(resultList);
            map.put("success",true);
        }catch(Exception e){
            map.put("success",false);
            map.put("message","保存失败");
        }
        return map;
    }

}
