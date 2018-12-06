package pers.dao;

import pers.bean.Goods;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/3 16:18
 * @Version 1.0
 */
public class GoodsDao extends DBdao {

    @Override
    public void changeList(List list) {
        try {
            while (rs.next()) {
                Goods g = new Goods(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(g);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object changeObj() {
        Object obj = null;
        try {
            if (rs.next()) {
                obj= new Goods(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
