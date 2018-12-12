package pers.dao;

import pers.bean.Orders;

import java.sql.SQLException;
import java.util.List;



public class OrdersDao extends DBdao{
	
	@Override
	public Object changeObj() {
		Object obj = null;
		try {
			if(rs.next()) {
				obj= new Orders(rs.getString(1), rs.getInt(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6));
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
				Orders c = new Orders(rs.getString(1), rs.getInt(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}
