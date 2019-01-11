package com.xagc.mtms.entity;

import org.apache.ibatis.type.Alias;

/**
 * @Author: Eve
 * @Date: 2019/1/10 14:29
 * @Version 1.0
 */
@Alias("Type")
public class Type {
    private Integer id;
    private String name;
    private String icon;

    public Type() {
    }

    public Type(Integer id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
