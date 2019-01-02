package pers.jdbcdemo;

import java.sql.*;

/**
 * @Author: Eve
 * @Date: 2018/12/30 15:16
 * @Version 1.0
 */
public class JdbcDemo {
    static Connection connection = null;
    static PreparedStatement preparedStatementstatement = null;
    static ResultSet rs = null;
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/java_db?" +
            "&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeResource(Connection connection, Statement statement, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        find("'or 1 = 1 #","' or 1 = '1");
    }
        public static void find(String user,String password) throws SQLException {
            try {
                preparedStatementstatement = getConn()
                        .prepareStatement("select * from test where name =? and password = ?");
                preparedStatementstatement.setObject(1,user);
                preparedStatementstatement.setObject(2,password);
                rs = preparedStatementstatement.executeQuery();
                while (rs.next()){
                    System.out.print(rs.getInt(1)
                            +", "+rs.getString(2)
                            +", "+rs.getString(3));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                closeResource(connection,preparedStatementstatement,rs);
            }
        }
}
