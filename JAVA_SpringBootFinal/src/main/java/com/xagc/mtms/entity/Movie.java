package com.xagc.mtms.entity;

import org.apache.ibatis.type.Alias;

/**
 * @Author: Eve
 * @Date: 2019/1/10 14:28
 * @Version 1.0
 */
@Alias("Movie")
public class Movie {
    private Integer id;
    private String title;
    private String desc;
    private String pic;
    private Type type;

    public Movie() {
    }

    public Movie(Integer id, String title, String desc, String pic, Type type) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.pic = pic;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", pic='" + pic + '\'' +
                ", type=" + type +
                '}';
    }
}
