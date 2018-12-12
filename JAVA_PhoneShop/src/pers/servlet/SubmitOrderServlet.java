package pers.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import pers.bean.Car;
import pers.bean.Orders;
import pers.bean.User;
import pers.service.CarService;
import pers.service.OrdersService;
import pers.util.CurrentTime;
import pers.util.IDutil;

//提交订单
@WebServlet("/SubmitOrderServlet")
public class SubmitOrderServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) //
			throws ServletException, IOException {//
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 获取session
		HttpSession session = request.getSession();
		// 获取登录者的id
		User u = (User) session.getAttribute("user");

		// 获取提交订单中的name值
		Map<String, String[]> map = request.getParameterMap();
		String[] cid = map.get("cids");
		String cids = String.join(",", cid);

		String address = request.getParameter("address");

		// 查询之后，获取总金额
		CarService cs = new CarService();
		int money = 0;
		// 获取提交购物车中选中的集合
		List<Car> car = cs.findByIdReadyOrder2(cids);
		for (Car c2 : car) {
			int cnum = c2.getCnum();
			int cmoney = c2.getCmoney();
			money += cnum * cmoney;
		}

		OrdersService os = new OrdersService();
		Orders o = new Orders();
		String oid = IDutil.getID();
		// 设置oid
		o.setOid(oid);
		// 设置总金额
		o.setOtotalMoney(money);
		// 设置地址
		o.setOaddress(address);
		String time = CurrentTime.getCurrentTime();
		// 设置当前时间
		o.setoTime(time);
		// 设置用户id
		o.setU_id(u.getU_id());
		// 执行插入数据操作
		os.insertOrders(o, car);
		
//		跳转到查询自己订单的页面
		response.sendRedirect("FindUserOrders");

	}
}