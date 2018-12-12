package pers.service;


import pers.bean.OrdersDetail;
import pers.dao.DBdao;
import pers.dao.OrdersDetailDao;

import java.util.List;

//订单明细表的业务
public class OrdersDetailService {
	
	DBdao db = new OrdersDetailDao();

	//添加订单明细表
	public void insertOrdersDetail(OrdersDetail o){
		String sql = "insert into ordersdetail"
				+ "(odnum,odmoney,odtotalmoney,odaddress,oid,gid)"
				+ "values"
				+ "("+o.getOdnum()+","+o.getOdmoney()+","+o.getOdtotalmoney()+""
				+ ",'"+o.getOdaddress()+"','"+o.getOid()+"',"+o.getGid()+")";
		db.update(sql);
	}
	
	//查询所有订单明细
	public List<OrdersDetail> findAll(){
		String sql = "select * from ordersdetail";
		List<OrdersDetail> list = db.query(sql);	
		return list;
	}

}
