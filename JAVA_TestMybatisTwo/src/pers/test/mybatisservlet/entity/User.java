package pers.test.mybatisservlet.entity;

import org.apache.ibatis.type.Alias;

/**
 * @Author: Eve
 * @Date: 2018/12/26 9:20
 * @Version 1.0
 */
@Alias("user")
public class User {
    Integer id;
    String name;
    String password;
    String address;

    public User() {
    }
    public User(Integer id, String name, String password, String address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public User(String name, String password, String address) {
        this.name = name;
        this.password = password;
        this.address = address;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
