package pers.car.action.car;

import com.google.gson.Gson;
import pers.car.entity.Car;
import pers.car.service.ICarService;
import pers.car.service.Impl.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/19 14:32
 * @Version 1.0
 */
@WebServlet("/findcarsbynameandprice")
public class findCarsNameAndPrice extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String sprice = req.getParameter("price");
        String[] price = sprice.split("-");
        Double min = Double.parseDouble(price[0]);
        Double max = Double.parseDouble(price[1]);
        ICarService i = new CarServiceImpl();
        List<Car> list = i.findCarsBynameAndPrice(brand,min,max);
        Gson g = new Gson();
        resp.getWriter().print(g.toJson(list));

    }
}
