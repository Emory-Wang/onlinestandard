package com.project.entity;

public class StandardClass {
    private Integer id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "StandardClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
