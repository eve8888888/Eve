package pers.car.entity;

import java.util.Date;

/**
 * @Author: Eve
 * @Date: 2018/12/17 9:20
 * @Version 1.0
 */
public class Car {
    Integer id;
    String brand;
    String color;
    Date date;
    Double price;
    String pic;
    String desc;

    public Car(Integer id, String brand, String color,
               Date date, Double price, String pic,
               String desc) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.date = date;
        this.price = price;
        this.pic = pic;
        this.desc = desc;
    }

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

}
