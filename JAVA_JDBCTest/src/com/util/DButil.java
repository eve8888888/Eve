package com.util;

import java.sql.*;

/**
 * @Author: Eve
 * @Date: 2018/11/29 16:54
 * @Version 1.0
 */
public class DButil {
    private static Connection connection = null;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String NAME = "root";
    private static final String PWD = "1234";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        try {
            connection = DriverManager.getConnection(URL, NAME, PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeResource(Connection connection, Statement statement, ResultSet re) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection释放成功");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //System.out.println("Connection释放失败");
        }
        if (statement != null) {
            try {
                statement.close();
                System.out.println("Statement释放成功");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //System.out.println("Statement释放失败");
        }
        if (re != null) {
            try {
                re.close();
                System.out.println("ResultSet释放成功");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //System.out.println("ResultSet释放失败");
        }
    }
}