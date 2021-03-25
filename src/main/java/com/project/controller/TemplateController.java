package com.project.controller;

import com.project.entity.City;
import com.project.entity.Template;
import com.project.service.ICityService;
import com.project.service.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Template")
public class TemplateController {
    @Autowired
    private ITemplateService templateService;

    //步骤2界面加载时 给模板选择下拉框赋值时调用
    @GetMapping("/findAll")
    public List<Template> findAll(){
        return templateService.findAll();
    }

    @PostMapping("/insert")
    public int insert(@RequestBody Template template){
        return templateService.insert(template);

    }

    @PostMapping("/edit")
    public int edit(@RequestBody Template template){
        return templateService.edit(template);
    }

    @GetMapping("/delete")
    public int delete(@RequestParam("id")String id){
        return templateService.delete(Integer.parseInt(id));
    }

    @GetMapping("/select")
    public String select(@RequestParam("id")String id){
        return templateService.select(Integer.parseInt(id)).getName();
    }


}
