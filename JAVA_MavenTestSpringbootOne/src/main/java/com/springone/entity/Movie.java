package com.springone.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @Author: Eve
 * @Date: 2019/1/4 15:24
 * @Version 1.0
 */
@Alias("Movie")
public class Movie {
    private Integer id;
    private String name;
    private Double price;
    private String desc;
    private String pic;
    private Type type;
    private Date date;
    private Integer rate;
    private Director director;
    private Cinema cinema;

    public Movie(Integer id,
                 String name,
                 Double price,
                 String desc,
                 String pic,
                 Type type,
                 Date date,
                 Integer rate,
                 Director director,
                 Cinema cinema) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.pic = pic;
        this.type = type;
        this.date = date;
        this.rate = rate;
        this.director = director;
        this.cinema = cinema;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", desc='" + desc + '\'' +
                ", pic='" + pic + '\'' +
                ", type=" + type +
                ", date=" + date +
                ", rate=" + rate +
                ", director=" + director +
                ", cinema=" + cinema +
                '}';
    }
}
