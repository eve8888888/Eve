package pers.springone.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: Eve
 * @Date: 2019/1/2 9:21
 * @Version 1.0
 */
public class Person {
    private String name;
    private Car car;
    private List<Car> list;
    private Map<String,Car> map;
    private Properties properties;

    public Person() {
    }

    public Person(String name, Car car, List<Car> list, Map<String, Car> map, Properties properties) {
        this.name = name;
        this.car = car;
        this.list = list;
        this.map = map;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Car> getList() {
        return list;
    }

    public void setList(List<Car> list) {
        this.list = list;
    }

    public Map<String, Car> getMap() {
        return map;
    }

    public void setMap(Map<String, Car> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", list=" + list +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
