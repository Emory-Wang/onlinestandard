package com.project.entity;

import java.util.List;

public class Item {
    private Integer id;
    private Integer first_level_id;
    private Integer second_level_id;
    private String short_cut;
    private Boolean property_related;

    private List<Equipment> equipmentList;

    private String equips;

    private int[][] properties;

    //private Standard standard;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFirst_level_id() {
        return first_level_id;
    }

    public void setFirst_level_id(Integer first_level_id) {
        this.first_level_id = first_level_id;
    }

    public Integer getSecond_level_id() {
        return second_level_id;
    }

    public void setSecond_level_id(Integer second_level_id) {
        this.second_level_id = second_level_id;
    }

    public String getShort_cut() {
        return short_cut;
    }

    public void setShort_cut(String short_cut) {
        this.short_cut = short_cut;
    }

    public Boolean getProperty_related() {
        return property_related;
    }

    public void setProperty_related(Boolean property_related) {
        this.property_related = property_related;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public String getEquips() {
        return equips;
    }

    public void setEquips(String equips) {
        this.equips = equips;
    }

    public int[][] getProperties() {
        return properties;
    }

    public void setProperties(int[][] properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", first_level_id=" + first_level_id +
                ", second_level_id=" + second_level_id +
                ", short_cut='" + short_cut + '\'' +
                ", property_related=" + property_related +
                ", equipmentList=" + equipmentList +
                '}';
    }
}
