package pers.dao;

import pers.bean.OrdersDetail;

import java.sql.SQLException;
import java.util.List;


public class OrdersDetailDao extends DBdao {

	int odid;
	int odnum;
	int odmoney;
	int odtotalmoney;
	String odaddress;
	String odstatus;
	String oid;
	int gid;
	
	@Override
	public Object changeObj() {
		Object obj = null;
		try {
			if(rs.next()) {
				obj= new OrdersDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getInt(4), rs.getString(5), rs.getString(6)
						, rs.getString(7), rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@Override
	public void changeList(List list) {
		try {
			while (rs.next()) {
				OrdersDetail c = new OrdersDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3), 
						rs.getInt(4), rs.getString(5), rs.getString(6)
						, rs.getString(7), rs.getInt(8));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
