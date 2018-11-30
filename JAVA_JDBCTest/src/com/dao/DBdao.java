package com.dao;

import com.bean.Student;
import com.util.DButil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/11/30 14:44
 * @Version 1.0
 */
public class DBdao {
    Connection conn;
    Statement statement = null;
    public void update(String sql){
        conn = DButil.getConn();
        try {
            statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.closeResource(conn,statement,null);
        }
    }
    public Object findById(String sql){
        ResultSet rs = null;
        Object obj = null;
        conn = DButil.getConn();
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            if(rs.next()){
                obj = new Student(rs.getInt(1),
                        rs.getString(2),rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.closeResource(conn,statement,rs);
        }
        return obj;
    }
    public List findAll(String sql){
        List<Student> list = new LinkedList<>();
        ResultSet rs = null;
        conn = DButil.getConn();
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()){
                list.add(new Student(rs.getInt(1),
                        rs.getString(2),rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.closeResource(conn,statement,rs);
        }
        return list;
    }
    public int count(String sql){
        ResultSet rs = null;
        int count = 0;
        conn = DButil.getConn();
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            if (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil.closeResource(conn,statement,rs);
        }
        return count;
    }

}
