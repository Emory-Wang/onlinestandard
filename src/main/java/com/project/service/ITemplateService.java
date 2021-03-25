package com.project.service;

import com.project.entity.City;
import com.project.entity.Template;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ITemplateService {

    //查询所有
    public List<Template> findAll();

    public int insert(Template record);

    public int edit(Template record);

    public int delete(int id);

    public Template select(int id);


}
