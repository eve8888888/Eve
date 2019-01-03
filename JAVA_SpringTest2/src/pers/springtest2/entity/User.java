package pers.springtest2.entity;

import java.util.Date;

/**
 * @Author: Eve
 * @Date: 2019/1/2 14:50
 * @Version 1.0
 */
public class User {
    String name;
    Integer age;
    Date date;

    public User() {
    }

    public User(String name, Integer age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
