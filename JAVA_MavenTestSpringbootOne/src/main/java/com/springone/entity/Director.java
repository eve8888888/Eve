package com.springone.entity;

import org.apache.ibatis.type.Alias;

/**
 * @Author: Eve
 * @Date: 2019/1/4 15:24
 * @Version 1.0
 */
@Alias("Director")
public class Director {
    private Integer id;
    private String name;
    private String desc;

    public Director(Integer id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
