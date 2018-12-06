package pers.util;

import java.sql.*;

/**
 * @Author: Eve
 * @Date: 2018/11/29 16:54
 * @Version 1.0
 */
public class DButil {
    private static Connection connection = null;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test_oa2?characterEncoding=utf-8";
    private static final String NAME = "root";
    private static final String PWD = "1234";
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("��������ʧ��****************");
        }
    }


    public static Connection getConn() {
        try {
            connection = DriverManager.getConnection(URL, NAME, PWD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("��ȡconnʧ��**********************");
        }
        return connection;
    }

    public static void closeResource(Connection connection, Statement statement, ResultSet re) {
        try {
            if (!connection.isClosed()) {
                connection.close();
                System.out.println("Connection�ͷųɹ�");
            } else {
                System.out.println("Connection�Ѿ��ر�");
            }
            if (!statement.isClosed()) {
                statement.close();
                System.out.println("Statement�ͷųɹ�");
            } else {
                System.out.println("Statement�Ѿ��ر�");
            }
            if (re != null &&!re.isClosed()) {
                re.close();
                System.out.println("ResultSet�ͷųɹ�");
            } else {
                System.out.println("ResultSet�Ѿ��ر�");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}