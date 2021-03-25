package com.project.controller;

import com.project.entity.City;
import com.project.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/City")
public class CityController {
    @Autowired
    private ICityService cityService;

    //下拉框选城市所在页面加载时调用
    @GetMapping("/findAll")
    public List<City> findAll(){
        return cityService.findAll();
    }

    @GetMapping("/findProvince")
    public List<City> findProvince(Integer id){
        return cityService.findProvince(id);
    }

}
