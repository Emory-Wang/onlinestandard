package com.project.entity;

public class TemplateLevel {
    private Integer id;

    private Integer template_id;

    private Integer second_level_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(Integer template_id) {
        this.template_id = template_id;
    }

    public Integer getSecond_level_id() {
        return second_level_id;
    }

    public void setSecond_level_id(Integer second_level_id) {
        this.second_level_id = second_level_id;
    }
}