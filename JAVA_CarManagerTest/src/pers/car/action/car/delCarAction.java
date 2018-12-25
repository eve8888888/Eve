package pers.car.action.car;

import pers.car.service.ICarService;
import pers.car.service.Impl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/12/19 11:08
 * @Version 1.0
 */
@WebServlet("/delCar.action")
public class delCarAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ICarService i = new CarServiceImpl();
        i.deleteCar(id);
        resp.getWriter().print("删除成功");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
