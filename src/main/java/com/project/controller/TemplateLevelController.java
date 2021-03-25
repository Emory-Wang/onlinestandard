package com.project.controller;

import com.project.entity.FirstLevel;
import com.project.entity.SecondLevel;
import com.project.entity.TemplateLevel;
import com.project.service.IFirstLevelService;
import com.project.service.ISecondLevelService;
import com.project.service.ITemplateLevelService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TemplateLevel")
public class TemplateLevelController {
    @Autowired
    private ITemplateLevelService iTemplateLevelService;

    @Autowired
    private IFirstLevelService iFirstLevelService;

    @Autowired
    private ISecondLevelService iSecondLevelService;

    @GetMapping("/list")
    public List<FirstLevel> findList(@RequestParam("tempId")String tempId){
        List<FirstLevel> templateLevels = iTemplateLevelService.findThree(Integer.parseInt(tempId));
        for(FirstLevel firstLevel:templateLevels){
            firstLevel.setFirst_level_id(0);
        }
        return templateLevels;
    }

    //查找不在模板中一级分类
    @GetMapping("/firstLevels")
    public List<FirstLevel> findFirstRemainder(@RequestParam("tempId")String tempId){
        List<TemplateLevel> templateLevelList = iTemplateLevelService.selectByTempId(Integer.parseInt(tempId));
        //System.out.println(templateLevelList);
        List<FirstLevel> levels = null;
        if(templateLevelList.size() == 0){
            levels = iFirstLevelService.findAll();
        }else{
            levels = iTemplateLevelService.findFirstRemainder(templateLevelList);
        }
        for(FirstLevel firstLevel:levels){
            firstLevel.setFirst_level_id(0);
        }
        return levels;
    }

    //查找不在模板中二级分类
    @GetMapping("/secondLevels")
    public List<SecondLevel> findSecondRemainder(@RequestParam("tempId")String tempId,@RequestParam("first_level_id")String firstId){
        List<TemplateLevel> templateLevelList = iTemplateLevelService.selectByTempId(Integer.parseInt(tempId));
        List<SecondLevel> levels = null;
        if(templateLevelList.size() == 0){
            levels = iSecondLevelService.selectByFirstLevel(Integer.parseInt(firstId));
        }else{
            levels = iTemplateLevelService.findSecondRemainder(Integer.parseInt(firstId),templateLevelList);
        }

        return levels;
    }

    @PostMapping("/insert")
    public int insert(@RequestBody TemplateLevel templateLevel){
        return iTemplateLevelService.insert(templateLevel);
    }

    @GetMapping("/deleteSecondLevel")
    public int deleteSecondLevel(@RequestParam("tempId")String tempId,@RequestParam("id")String id){
        return iTemplateLevelService.deleteSecondLevel(Integer.parseInt(tempId),Integer.parseInt(id));
    }

    @GetMapping("/deleteFirstLevel")
    public int deleteFirstLevel(@RequestParam("tempId")String tempId,@RequestParam("id")String id){
        List<SecondLevel> secondLevelList = iSecondLevelService.selectByFirstLevel(Integer.parseInt(id));

        return iTemplateLevelService.deleteFirstLevel(Integer.parseInt(tempId),secondLevelList);
    }

}
