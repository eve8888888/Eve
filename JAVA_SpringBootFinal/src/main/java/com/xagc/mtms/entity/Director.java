package com.xagc.mtms.entity;

import org.apache.ibatis.type.Alias;

/**
 * @Author: Eve
 * @Date: 2019/1/10 14:26
 * @Version 1.0
 */
@Alias("Director")
public class Director {
    private Integer id;
    private String name;
    private String desc;
    private String pic;

    public Director() {
    }

    public Director(Integer id, String name, String desc, String pic) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.pic = pic;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
