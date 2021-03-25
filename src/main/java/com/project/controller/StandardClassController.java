package com.project.controller;

import com.project.entity.Business;
import com.project.entity.StandardClass;
import com.project.service.IBusinessService;
import com.project.service.IStandardClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/StandardClass")
public class StandardClassController {
    @Autowired
    private IStandardClassService standardClassService;

    //下拉框选标准所属级别所在页面（步骤1）加载时调用
    @GetMapping("/findAll")
    public List<StandardClass> findAll(){
        return standardClassService.findAll();
    }

}
