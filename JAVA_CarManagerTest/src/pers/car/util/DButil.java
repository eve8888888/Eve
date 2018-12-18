package pers.car.util;

import java.sql.*;

/**
 * @Author: Eve
 * @Date: 2018/12/17 10:09
 * @Version 1.0
 */
public class DButil {
    private static DButil intance = null;
    private static Connection conn;
    private static PreparedStatement pst;
    private static ResultSet rs;
    public DButil(){
        regist();
    }
    public static DButil getInstance(){
        if(intance == null){
            intance = new DButil();
        }
        return intance;
    }
    public void regist() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void connection(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_db",
                    "root","1234");
            System.out.println("链接成功*******************");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void preparedStatement(String sql,Object...values){
        try {
            pst = conn.prepareStatement(sql);
            for (int i = 0; i < values.length; i++) {
                pst.setObject(i+1,values[i]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void exeuteUpdate(){
        try {
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ResultSet exeuteQuery(){
        try {
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public void close() {
        try {
            if(rs!= null){
                rs.close();
            }
            if(pst != null){
                pst.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
