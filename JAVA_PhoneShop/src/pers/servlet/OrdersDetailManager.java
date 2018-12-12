package pers.servlet;

import pers.bean.OrdersDetail;
import pers.service.OrdersDetailService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//查询所有订单明细
@WebServlet("/OrdersDetailManager")
public class OrdersDetailManager extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {//
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		OrdersDetailService ods = new OrdersDetailService();
		List<OrdersDetail> listOrdersDetail = ods.findAll();
		request.setAttribute("listOrdersDetail", listOrdersDetail);
		request.getRequestDispatcher("OrdersDetailList.jsp").forward(request, response);

	}

}