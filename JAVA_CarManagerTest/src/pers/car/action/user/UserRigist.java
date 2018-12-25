package pers.car.action.user;

import pers.car.entity.User;
import pers.car.service.IUserService;
import pers.car.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/12/25 9:22
 * @Version 1.0
 */
@WebServlet("/userregist.action")
public class UserRigist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        User user=new User();
        user.setUser_name(name);
        user.setUser_pwd(password);
        IUserService i=new UserServiceImpl();
        i.save(user);
        resp.getWriter().print("注册成功");


    }
}
