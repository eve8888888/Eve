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

}
