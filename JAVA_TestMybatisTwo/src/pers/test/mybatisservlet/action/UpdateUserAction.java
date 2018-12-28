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
 * @Date: 2018/12/26 15:24
 * @Version 1.0
 */
@WebServlet("/updateUser.action")
public class UpdateUserAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        IUserService i = new UserServiceImpl();
        i.updateUser(new User(Integer.parseInt(id),name,password,address));
        resp.getWriter().print("修改成功");
    }
}
