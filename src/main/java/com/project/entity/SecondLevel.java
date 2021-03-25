package com.project.entity;

import java.util.List;
import java.util.UUID;

public class SecondLevel {
    private Integer id;
    private String name;
    private Integer first_level_id;

    private List<Item> items;

    private String uuid;

/*    private Template template;
    private FirstLevel firstLevel;*/

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

    public Integer getFirst_level_id() {
        return first_level_id;
    }

    public void setFirst_level_id(Integer first_level_id) {
        this.first_level_id = first_level_id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
/*    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public FirstLevel getFirstLevel() {
        return firstLevel;
    }

    public void setFirstLevel(FirstLevel firstLevel) {
        this.firstLevel = firstLevel;
    }*/

    public String getUuid() {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "SecondLevel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", first_level_id=" + first_level_id +
                ", items=" + items +
                '}';
    }
}
