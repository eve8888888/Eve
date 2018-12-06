package pers.dao;

import pers.bean.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/4 8:33
 * @Version 1.0
 */
public class UserDao extends DBdao {

    @Override
    public Object changeObj() {
        Object obj = null;
        try {
            if(rs.next()){
                obj = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void changeList(List list) {


    }

}