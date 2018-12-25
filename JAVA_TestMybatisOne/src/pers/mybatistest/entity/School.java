package pers.mybatistest.entity;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @Author: Eve
 * @Date: 2018/12/25 14:21
 * @Version 1.0
 */
@Alias("school")
public class School {
    private Integer id;
    private String name;
    private String phone;
    private String address;
    private Date date;

    public School() {
    }

    public School(String name, String phone, String address, Date date) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.date = date;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                '}';
    }
}
