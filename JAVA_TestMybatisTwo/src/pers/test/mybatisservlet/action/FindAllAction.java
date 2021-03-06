package pers.test.mybatisservlet.action;

import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import pers.test.mybatisservlet.entity.User;
import pers.test.mybatisservlet.mapper.IUserMapper;
import pers.test.mybatisservlet.service.IUserService;
import pers.test.mybatisservlet.service.Impl.UserServiceImpl;
import pers.test.mybatisservlet.util.MybatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/26 10:55
 * @Version 1.0
 */
@WebServlet("/findAllUsers.action")
public class FindAllAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserService i = new UserServiceImpl();
        List<User> list = i.findAllUsers();
        Gson gson = new Gson();
        resp.getWriter().print(gson.toJson(list));
    }
}
