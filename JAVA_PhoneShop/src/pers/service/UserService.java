package pers.service;

import pers.bean.User;
import pers.dao.DBdao;
import pers.dao.UserDao;

/**
 * @Author: Eve
 * @Date: 2018/12/4 8:35
 * @Version 1.0
 */

//用户的业务类
public class UserService {

    DBdao db = new UserDao();

    //登录
    public User login(String uid, String pwd){
        String sql="SELECT * FROM USER WHERE"
                + " u_id='"+uid+"' AND u_pwd = '"+pwd+"';";
        System.out.println("sql-->"+sql);
        User u = (User) db.findById(sql);
        return u;
    }
}
