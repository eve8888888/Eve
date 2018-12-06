package pers.servlet;

import pers.service.CarService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//批量删除
@WebServlet("/DelsCarServlet")
public class DelsCarServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cids = request.getParameter("cids");
		CarService cs = new CarService();
		cs.delsCar(cids);
		//再去查询购物车
		response.sendRedirect("FindAllUserCarServlet");
	}

}
