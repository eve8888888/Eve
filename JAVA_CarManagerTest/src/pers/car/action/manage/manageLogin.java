package pers.car.action.manage;

import pers.car.entity.Manager;
import pers.car.service.IManageService;
import pers.car.service.Impl.IManageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/12/24 14:45
 * @Version 1.0
 */
@WebServlet("/managelogin.action")
public class manageLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        IManageService i = new IManageServiceImpl();
        Manager manager = i.findManageByNameAndPassword(name,password);
        if (manager != null){
            resp.sendRedirect("back/findCars.html");
        }else {
            resp.sendRedirect("back/managelogin.html");
        }
    }
}
