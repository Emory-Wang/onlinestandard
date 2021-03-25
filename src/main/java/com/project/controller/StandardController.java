package com.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.project.entity.City;
import com.project.entity.Standard;
import com.project.service.ICityService;
import com.project.service.IStandardItemService;
import com.project.service.IStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Standard")
public class StandardController {
    @Autowired
    private IStandardService standardService;
    @Autowired
    private IStandardItemService standardItemService;
    @Autowired
    private ICityService cityService;

    @GetMapping("/findAllStandard")
    public List<Standard> findAllStandard(){
        return standardService.findAllStandard();
    }

    //展示标准列表，含城市及分类信息   标准管理主界面加载时调用
    @GetMapping("/findAllStandardForm")
    public List<Standard> findAllStandardForm(){
        return standardService.findAllStandardForm();
    }

    //根据id找standard  新建标准的最后 和详情页 展示标准基本信息时调用
    @GetMapping("/findStandardById")
    public List<JSONObject> findStandardById(@RequestParam("standard_id") Integer standard_id){
        return standardService.findStandardById(standard_id);
    }

    //编辑标准，点击确定后调用
    @PostMapping("/edit")
    public Map<String,Object> edit(@RequestBody Standard standard){
        Map<String,Object> map = new HashMap<>();
        try{
            standardService.edit(standard);
            map.put("success",true);
        }catch(Exception e){
            map.put("success",false);
            map.put("message","修改失败");
        }
        return map;
    }

    //删除标准，点击确定后调用
    @GetMapping("/delete")
    public Map<String,Object> delete(Integer id){
        Map<String,Object> map = new HashMap<>();
        try{
            standardService.delete(id);
            //standardItemService.delete(id);
            map.put("success",true);
        }catch(Exception e){
            map.put("success",false);
            map.put("message","删除失败");
        }
        return map;
    }

    //新建标准 步骤1界面点击确定后调用
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody Standard standard){
        Map<String,Object> map = new HashMap<>();
        //province_id和city_id不能为空
        try{
            //首先查询和修改城市对应的省份id
            List<City> temcity = cityService.findProvince(standard.getCity_id());
            int prov_id = temcity.get(0).getProv_id();
            standard.setProvince_id(prov_id);
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateNowStr = sdf.format(d);
            standard.setDate(dateNowStr);
            standardService.insert(standard);
            map.put("success",true);
        }catch(Exception e){
            map.put("success",false);
            map.put("message","保存失败");
        }
        return map;
    }


}
