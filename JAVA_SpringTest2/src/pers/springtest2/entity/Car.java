package pers.springtest2.entity;

import org.springframework.stereotype.Component;

/**
 * @Author: Eve
 * @Date: 2019/1/2 14:48
 * @Version 1.0
 */
@Component("car")
public class Car {
    private String brand;
    private String color;

    public Car() {
    }

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
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

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
