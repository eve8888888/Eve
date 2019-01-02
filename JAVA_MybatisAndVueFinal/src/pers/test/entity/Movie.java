package pers.test.entity;

import org.apache.ibatis.type.Alias;

/**
 * @Author: Eve
 * @Date: 2018/12/28 9:21
 * @Version 1.0
 */
@Alias("movie")
public class Movie {
    private Integer id;
    private String name;
    private Double price;
    private String desc;
    private String pic;
    private Type type;

    public Movie() {
    }

    public Movie(Integer id, String name, Double price, String desc, String pic, Type type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.pic = pic;
        this.type = type;
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

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                ", pic='" + pic + '\'' +
                ", type=" + type +
                '}';
    }
}
