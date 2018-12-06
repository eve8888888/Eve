package pers.dao;

import pers.bean.Car;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/6 9:07
 * @Version 1.0
 */
public class CarDao extends DBdao {

    @Override
    public Object changeObj() {
        Object obj = null;
        try {
            if(rs.next()) {
                obj= new Car(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)
                        , rs.getInt(7), rs.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void changeList(List list) {
        try {
            while (rs.next()) {
                Car c = new Car(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)
                        , rs.getInt(7), rs.getString(8));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
