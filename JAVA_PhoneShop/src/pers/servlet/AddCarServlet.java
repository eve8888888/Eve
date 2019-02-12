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
import pers.bean.Goods;
import pers.bean.User;
import pers.service.CarService;
import pers.service.GoodsService;

//添加到购物车
@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取href中的商品的id
		int gid = Integer.parseInt(request.getParameter("gid"));
		System.out.println("gid--->"+gid);
		
		//获取会话域，即session
		HttpSession session = request.getSession();
		//获取登录时候的user
		User u = (User) session.getAttribute("user");
		GoodsService gs = new GoodsService();
		//查询操作
		Goods g = gs.findById(gid);
		CarService cs = new CarService();
		//把查询出的单个商品的数据导入到car对象中
		Car c = new Car(g.getGmoney(),g.getGname(),g.getGimage()
				,g.getGid(),u.getU_id());
		System.out.println("c--->"+c);
		//添加操作
		cs.addCar(c);
		//添加完成后，直接查询用户的购物车
		response.sendRedirect("FindAllUserCarServlet");
	}
}
