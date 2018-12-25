package pers.car.action.user;

import com.google.gson.Gson;
import pers.car.entity.Car;
import pers.car.entity.User;
import pers.car.service.ICarService;
import pers.car.service.IUserService;
import pers.car.service.Impl.CarServiceImpl;
import pers.car.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/24 15:22
 * @Version 1.0
 */
@WebServlet("/findAllUsers.action")
public class findAllUsersAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IUserService i = new UserServiceImpl();
        Gson g = new Gson();
        List<User> list = i.findAllUsers();
        resp.getWriter().print(g.toJson(list));
        System.out.println(list);
    }
}
