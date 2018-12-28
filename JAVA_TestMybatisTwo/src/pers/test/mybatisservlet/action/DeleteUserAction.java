package pers.test.mybatisservlet.action;

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
 * @Date: 2018/12/26 15:15
 * @Version 1.0
 */
@WebServlet("/delUser.action")
public class DeleteUserAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        IUserService i = new UserServiceImpl();
        i.deleteUser(Integer.parseInt(id));
        resp.getWriter().print("删除成功");
    }
}
