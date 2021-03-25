package com.project.entity;

import java.util.List;

public class Template {
    private Integer id;
    private String name;

    private List<SecondLevel> secondLevels;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Template{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
