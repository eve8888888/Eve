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
 * @Date: 2018/12/24 15:05
 * @Version 1.0
 */

@WebServlet("/userlogin.action")
public class userLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        IUserService i=new UserServiceImpl();
        System.out.println(name+"*****"+password);
        User user=i.findUserByNameAndPassword(name,password);
        System.out.println(user);
        if(user!=null){
            resp.getWriter().print("success");
        }else{
            resp.sendRedirect("userlogin.html");
        }

    }
}
