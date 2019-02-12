package pers.servlet;

import pers.bean.Car;
import pers.service.CarService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//提交预备订单
@WebServlet("/ReadyOrderServlet")
public class ReadyOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {//
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		//获取href中cids
		String cids = request.getParameter("cids");
		CarService cs = new CarService();
		List<Car> listReadyOrderCar = cs.findByIdReadyOrder(cids);
		System.out.println("listReadyOrderCar------>"+listReadyOrderCar.size());
		request.setAttribute("listReadyOrderCar", listReadyOrderCar);
		request.getRequestDispatcher("ReadyOrder.jsp").forward(request, response);


	}

}