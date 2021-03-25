package com.project.service.impl;

import com.project.entity.City;
import com.project.entity.Template;
import com.project.mapper.cityMapper;
import com.project.mapper.templateMapper;
import com.project.service.ICityService;
import com.project.service.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements ITemplateService {

    @Autowired
    private templateMapper TemplateMapper;


    @Override
    public List<Template> findAll() {
        return TemplateMapper.findAll();
    }

    @Override
    public int insert(Template record) {
        return TemplateMapper.insert(record);
    }

    @Override
    public int edit(Template record) {
        return TemplateMapper.updateByPrimaryKey(record);
    }

    @Override
    public int delete(int id) {
        return TemplateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Template select(int id) {
        return TemplateMapper.selectByPrimaryKey(id);
    }
}
