package com.project.entity;

import java.util.List;
import java.util.UUID;

public class FirstLevel {
    private Integer id;
    private String name;

    private List<SecondLevel> children;//前端所需数据格式

    private Integer first_level_id;//前端所需数据格式

    private String uuid;//前端所需数据格式

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

    public List<SecondLevel> getSecondLevels() {
        return secondLevels;
    }

    public void setSecondLevels(List<SecondLevel> secondLevels) {
        this.secondLevels = secondLevels;
    }

    public List<SecondLevel> getChildren() {
        return children;
    }

    public void setChildren(List<SecondLevel> children) {
        this.children = children;
    }

    public Integer getFirst_level_id() {
        return first_level_id;
    }

    public void setFirst_level_id(Integer first_level_id) {
        this.first_level_id = first_level_id;
    }

    public String getUuid() {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "FirstLevel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondLevels=" + secondLevels +
                '}';
    }
}
