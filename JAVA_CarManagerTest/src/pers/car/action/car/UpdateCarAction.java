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
 * @Date: 2018/12/19 9:32
 * @Version 1.0
 */
@WebServlet("/updateCar.action")
public class UpdateCarAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String brand = req.getParameter("brand");
        String color = req.getParameter("color");
        String date = req.getParameter("date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Double price = Double.parseDouble(req.getParameter("price"));
        String desc = req.getParameter("desc");
        Car car = new Car(id,brand,color,d,price,UploadAction.getFileName(),desc);
        ICarService i = new CarServiceImpl();
        i.updateCar(car,id);
        resp.getWriter().print("修改成功");
    }
}
