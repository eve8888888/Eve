package pers.car.action.car;

import pers.car.entity.Car;
import pers.car.service.ICarService;
import pers.car.service.Impl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Eve
 * @Date: 2018/12/19 9:16
 * @Version 1.0
 */
@WebServlet("/addCar.action")
public class addCarAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String color = req.getParameter("color");
        String date = req.getParameter("date");
        System.out.println(color);
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = sdf.parse(date);
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Double price = Double.parseDouble(req.getParameter("price"));
        String pic = req.getParameter("pic");
        String desc = req.getParameter("desc");
        Car car = new Car();
        car.setBrand(brand);
        car.setColor(color);
        car.setDate(d);
        car.setPrice(price);
        car.setPic(pic);
        car.setDesc(desc);
        ICarService i = new CarServiceImpl();
        i.addCar(car);
        resp.getWriter().print("添加成功");
    }
}
