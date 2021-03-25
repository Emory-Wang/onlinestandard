package com.project.entity;

import java.util.List;

public class EquipProperty {
    private int value;

    private String label;

    private List<EquipProperty> children;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<EquipProperty> getChildren() {
        return children;
    }

    public void setChildren(List<EquipProperty> children) {
        this.children = children;
    }
}
