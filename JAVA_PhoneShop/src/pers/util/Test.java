package pers.util;

import java.sql.Connection;

/**
 * @Author: Eve
 * @Date: 2018/12/3 16:08
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Connection conn = DButil.getConn();
        System.out.println(conn);
    }
}
