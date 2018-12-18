package pers.car.action.car;

import com.google.gson.Gson;
import pers.car.entity.Car;
import pers.car.service.ICarService;
import pers.car.service.Impl.CarServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/18 9:43
 * @Version 1.0
 */
@WebServlet("/findAllCars.action")
public class FindAllCarsAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ICarService i = new CarServiceImpl();
        Gson g = new Gson();
        List<Car> list = i.findAllCar();
        resp.getWriter().print(g.toJson(list));
        System.out.println("****************************************");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }

}
