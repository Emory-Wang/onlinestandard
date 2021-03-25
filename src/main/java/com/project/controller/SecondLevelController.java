package com.project.controller;

import com.project.entity.FirstLevel;
import com.project.entity.SecondLevel;
import com.project.mapper.secondLevelMapper;
import com.project.service.ISecondLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SecondLevel")
public class SecondLevelController {

    @Autowired
    private ISecondLevelService secondLevelService;

    @GetMapping("/findAll")
    public List<SecondLevel> findAll(@RequestParam("first_level_id")String id){
        return secondLevelService.selectByFirstLevel(Integer.parseInt(id));
    }

    @PostMapping("/insert")
    public int insert(@RequestBody SecondLevel secondLevel){
        return secondLevelService.insert(secondLevel);
    }

    @PostMapping("/edit")
    public int edit(@RequestBody SecondLevel secondLevel){
        return secondLevelService.update(secondLevel);

    }

    @GetMapping("/delete")
    public int delete(@RequestParam("id")String idp){
        int id = Integer.parseInt(idp);
        return secondLevelService.delete(id);
    }


}
