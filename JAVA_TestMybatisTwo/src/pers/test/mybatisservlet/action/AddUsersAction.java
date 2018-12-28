package pers.test.mybatisservlet.action;

import pers.test.mybatisservlet.entity.User;
import pers.test.mybatisservlet.service.IUserService;
import pers.test.mybatisservlet.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/12/26 15:03
 * @Version 1.0
 */
@WebServlet("/addUser.action")
public class AddUsersAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        IUserService i = new UserServiceImpl();
        i.save(new User(name,password,address));
        resp.getWriter().print("添加成功");
    }
}
