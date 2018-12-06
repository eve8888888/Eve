package pers.servlet;

import pers.bean.User;
import pers.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/12/4 8:37
 * @Version 1.0
 */
//登录
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //获取表单中的name值
        String u_id = request.getParameter("u_id");
        String u_pwd = request.getParameter("u_pwd");

        UserService us = new UserService();
        User user = us.login(u_id, u_pwd);
        System.out.println("user-->"+user);
        //获取会话域，即session
        HttpSession session = request.getSession();
        if(user==null){
            //重定向的跳转
            response.sendRedirect("index.jsp");
        }else{
            //存入session
            session.setAttribute("user", user);
            //转发的跳转
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }

    }

}
