package pers.car.dao.Impl;

import pers.car.dao.IManageDao;
import pers.car.entity.Manager;
import pers.car.entity.User;
import pers.car.util.DButil;

import java.sql.ResultSet;

/**
 * @Author: Eve
 * @Date: 2018/12/24 14:10
 * @Version 1.0
 */
public class IManageDaoImpl implements IManageDao {
    @Override
    public Manager findManageByNameAndPassword(String name, String pwd) {
        DButil db = DButil.getInstance();
        db.connection();
        String sql = "select * from manager_table " +
                "where manager_name =? and manager_pwd=?";
        db.preparedStatement(sql, name, pwd);
        ResultSet rs = db.exeuteQuery();
        Manager manager = null;
        try {
            while (rs.next()) {
                manager = new Manager(
                        rs.getInt("manager_id"),
                        rs.getString("manager_name"),
                        rs.getString("manager_pwd")

                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        return manager;
    }
}
