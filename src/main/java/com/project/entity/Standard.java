package com.project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Standard {
    //@JsonProperty(value = "standard_id")
    private Integer id;
    private Integer business_id;
    private Integer class_id;
    private String name;
    private String file;
    private Integer province_id;
    private Integer city_id;
    private String date;
    //持有Business、StandardClass的引用用于多表查询
    private Business business;
    private StandardClass standardClass;
    private List<Item> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public StandardClass getStandardClass() {
        return standardClass;
    }

    public void setStandardClass(StandardClass standardClass) {
        this.standardClass = standardClass;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "id=" + id +
                ", business_id=" + business_id +
                ", class_id=" + class_id +
                ", name='" + name + '\'' +
                ", file='" + file + '\'' +
                ", province_id=" + province_id +
                ", city_id=" + city_id +
                ", date='" + date + '\'' +
                ", business=" + business +
                ", standardClass=" + standardClass +
                ", items=" + items +
                '}';
    }
}
