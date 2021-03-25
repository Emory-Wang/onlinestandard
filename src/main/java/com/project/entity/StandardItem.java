package com.project.entity;

public class StandardItem {
    private Integer id;
    private Integer standard_id;
    private Integer item_id;
    private Boolean property_related;
    private Boolean property_type;
    private Integer value_1;
    private Integer value_2;
    private Boolean required;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStandard_id() {
        return standard_id;
    }

    public void setStandard_id(Integer standard_id) {
        this.standard_id = standard_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Boolean getProperty_related() {
        return property_related;
    }

    public void setProperty_related(Boolean property_related) {
        this.property_related = property_related;
    }

    public Boolean getProperty_type() {
        return property_type;
    }

    public void setProperty_type(Boolean property_type) {
        this.property_type = property_type;
    }

    public Integer getValue_1() {
        return value_1;
    }

    public void setValue_1(Integer value_1) {
        this.value_1 = value_1;
    }

    public Integer getValue_2() {
        return value_2;
    }

    public void setValue_2(Integer value_2) {
        this.value_2 = value_2;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    @Override
    public String toString() {
        return "StandardItem{" +
                "id=" + id +
                ", standard_id=" + standard_id +
                ", item_id=" + item_id +
                ", property_related=" + property_related +
                ", property_type=" + property_type +
                ", value_1=" + value_1 +
                ", value_2=" + value_2 +
                ", required=" + required +
                '}';
    }
}
