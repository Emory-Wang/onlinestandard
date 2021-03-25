package com.project.entity;

import java.util.List;

public class Equipment {
    private Integer id;

    private String equip_name;

    private String equip_type;

    private String propers;

    private List<Property> properties;

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", equip_name='" + equip_name + '\'' +
                ", equip_type='" + equip_type + '\'' +
                ", propers='" + propers + '\'' +
                ", properties=" + properties +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquip_name() {
        return equip_name;
    }

    public void setEquip_name(String equip_name) {
        this.equip_name = equip_name;
    }

    public String getEquip_type() {
        return equip_type;
    }

    public void setEquip_type(String equip_type) {
        this.equip_type = equip_type;
    }

    public String getPropers() {
        return propers;
    }

    public void setPropers(String propers) {
        this.propers = propers;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
