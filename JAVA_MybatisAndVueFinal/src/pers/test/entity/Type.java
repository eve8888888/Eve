package pers.test.entity;

import org.apache.ibatis.type.Alias;

/**
 * @Author: Eve
 * @Date: 2018/12/28 9:19
 * @Version 1.0
 */
@Alias("type")
public class Type {
    Integer id;
    String name;

    public Type() {
    }

    public Type(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
