package com.project.entity;

public class Property {
    private Integer id;

    private Integer equip_id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquip_id() {
        return equip_id;
    }

    public void setEquip_id(Integer equip_id) {
        this.equip_id = equip_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", equip_id=" + equip_id +
                ", name='" + name + '\'' +
                '}';
    }
}
