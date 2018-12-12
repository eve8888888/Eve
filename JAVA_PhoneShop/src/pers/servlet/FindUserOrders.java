package pers.servlet;

import pers.bean.Orders;
import pers.bean.User;
import pers.service.OrdersService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



//查询所有订单
@WebServlet("/FindUserOrders")
public class FindUserOrders extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {//
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 获取session
		HttpSession session = request.getSession();
		// 获取登录者的id
		User u = (User) session.getAttribute("user");
		
		
		//查询所有订单
		OrdersService os = new OrdersService();
		List<Orders> userOrders = os.findAllUserOrders(u.getU_id());
		request.setAttribute("userOrders", userOrders);
		request.getRequestDispatcher("UserOrdersList.jsp").forward(request, response);
	}

}