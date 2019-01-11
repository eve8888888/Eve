package com.springone.entity;

import org.apache.ibatis.type.Alias;

/**
 * @Author: Eve
 * @Date: 2019/1/4 15:25
 * @Version 1.0
 */
@Alias("FindByLikeCondition")
public class FindByLikeCondition {
    private Integer current;
    private String desc;
    private String price;
    private Integer pageSize;
    private String name;

    public FindByLikeCondition(Integer current, String desc, String price, Integer pageSize, String name) {
        this.current = current;
        this.desc = desc;
        this.price = price;
        this.pageSize = pageSize;
        this.name = name;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FindByLikeCondition{" +
                "current=" + current +
                ", desc='" + desc + '\'' +
                ", price='" + price + '\'' +
                ", pageSize=" + pageSize +
                ", name='" + name + '\'' +
                '}';
    }
}
