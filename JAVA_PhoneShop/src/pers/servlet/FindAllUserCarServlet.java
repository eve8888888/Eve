package pers.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import pers.bean.Car;
import pers.bean.User;
import pers.service.CarService;

//添加到购物车
@WebServlet("/FindAllUserCarServlet")
public class FindAllUserCarServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		//获取会话域，即session
		HttpSession session = request.getSession();
		//获取登录时候的user
		User u = (User) session.getAttribute("user");
	
		CarService cs = new CarService();

		//去查询购物车
		List<Car> listCar = cs.findById(u.getU_id());
		//存入session
		session.setAttribute("listCar", listCar);
		response.sendRedirect("UserCarList.jsp");

	}

}
