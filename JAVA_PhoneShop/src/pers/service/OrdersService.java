package pers.service;


import pers.bean.Car;
import pers.bean.Orders;
import pers.bean.OrdersDetail;
import pers.dao.DBdao;
import pers.dao.OrdersDao;

import java.util.List;

public class OrdersService {
	
	DBdao db = new OrdersDao();
	OrdersDetailService ods = new OrdersDetailService();
	CarService cs = new CarService();
	
	//提交订单
	public void insertOrders(Orders o, List<Car> listc){
		//给订单表添加数据
		String sql = "insert into orders"
				+ "(oid,ototalMoney,oaddress,oTime,u_id)"
				+ " values('"+o.getOid()+"',"+o.getOtotalMoney()+""
				+ ",'"+o.getOaddress()+"','"+o.getoTime()+"','"+o.getU_id()+"')";
		
		boolean f = db.update(sql);
		System.out.println("sql-----"+sql);
		System.out.println("f-----"+f);
		//如果订单表添加数据成功
		if(f){
			//把选中的商品导入订单明细
			for (Car c : listc) {
				OrdersDetail od = new OrdersDetail();
				od.setOdnum(c.getCnum());
				od.setOdmoney(c.getCmoney());
				od.setOdtotalmoney(c.getCnum()*c.getCmoney());
				od.setOdaddress(o.getOaddress());
				od.setOid(o.getOid());
				od.setGid(c.getGid());
				ods.insertOrdersDetail(od);
				//同时删除购物车中的响应的商品
				cs.delCar(c.getCid());
			}
		}
	}
	
	//查询所有订单
	public List<Orders> findAllUserOrders(String uid){
		String sql = "select * from orders where u_id = '"+uid+"'";
		List<Orders> list = db.query(sql);
		return list;
	}
	
}
