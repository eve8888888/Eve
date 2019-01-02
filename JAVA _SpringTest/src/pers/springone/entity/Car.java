package pers.springone.entity;

/**
 * @Author: Eve
 * @Date: 2019/1/2 9:19
 * @Version 1.0
 */
public class Car {
    Integer id;
    String brand;
    String color;
    Double price;

    public Car() {
    }

    public Car(Integer id, String brand, String color, Double price) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
