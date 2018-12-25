package pers.car.dao.Impl;

import pers.car.dao.IUserDao;
import pers.car.entity.User;
import pers.car.util.DButil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/21 16:51
 * @Version 1.0
 */
public class UserDaoImpl implements IUserDao {


    @Override
    public void save(User user) {
        DButil db = DButil.getInstance();
        db.connection();
        String sql = "insert into user values(?,?,?)";
        db.preparedStatement(sql, user.getUser_id(), user.getUser_name(), user.getUser_pwd());
        db.exeuteUpdate();
        db.close();
    }

    @Override
    public void delete(Integer id) {
        DButil db = DButil.getInstance();
        db.connection();
        String sql = "delete from user where user_id = ?";
        db.preparedStatement(sql, id);
        db.exeuteUpdate();
        db.close();
    }

    @Override
    public void update(User user) {
        DButil db = DButil.getInstance();
        db.connection();
        String sql = "update user set user_pwd=?,user_name=? where user_id = ?";
        db.preparedStatement(sql, user.getUser_pwd(), user.getUser_name(), user.getUser_id());
        db.exeuteUpdate();
        db.connection();
    }

    @Override
    public List<User> findAllUsers() {
        DButil db = DButil.getInstance();
        db.connection();
        String sql = "select * from user";
        db.preparedStatement(sql);
        ResultSet rs = db.exeuteQuery();
        List<User> list = new ArrayList<>();
        User user = null;
        try {
            while (rs.next()) {
                user = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_pwd")
                );
                //System.out.println(rs.getInt("user_id")+"***"+rs.getString("user_pwd" )+"***"+rs.getString("user_name"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return list;
    }

    @Override
    public User findUserByNameAndPassword(String name, String pwd) {
        DButil db = DButil.getInstance();
        db.connection();
        String sql = "select * from user " +
                "where user_name =? and user_pwd=?";
        db.preparedStatement(sql, name, pwd);
        ResultSet rs = db.exeuteQuery();
        User user = null;
        try {
            while (rs.next()) {
                user = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_pwd")

                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        return user;
    }

    @Override
    public List<User> findUsersByLikeName(String name) {
        DButil db = DButil.getInstance();
        db.connection();
        String sql = "select * from user " +
                "where user_name =like'%" + name + "%'";
        db.preparedStatement(sql);
        ResultSet rs = db.exeuteQuery();
        List<User> list = new ArrayList<>();
        try {
            while (rs.next()) {
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_pwd"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        return list;
    }
}
