package pers.dao;

import pers.util.DButil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/3 16:11
 * @Version 1.0
 */
public abstract class DBdao {

    Connection conn = null;
    Statement stat = null;
    ResultSet rs = null;

    //通用的增删改
    public boolean update(String sql){
        boolean f = false;
        conn = DButil.getConn();
        try {
            stat = conn.createStatement();
            f = stat.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }

    //查询单个
    public Object findById(String sql){
        Object obj = null;
        conn = DButil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            obj = changeObj();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    //是抽象方法，用于处理查询单个
    public abstract Object changeObj();

    //查询所有的方法
    public List query(String sql){
        List list = new ArrayList();
        conn = DButil.getConn();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            changeList(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DButil.closeResource(conn,stat,null);
        }
        return list;
    }

    //是抽象方法，用于处理查询所有
    public abstract void changeList(List list);
}