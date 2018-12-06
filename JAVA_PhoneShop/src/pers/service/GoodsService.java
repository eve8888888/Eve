package pers.service;

import pers.bean.Goods;
import pers.dao.DBdao;
import pers.dao.GoodsDao;

import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/3 16:21
 * @Version 1.0
 */
//手机的业务类
public class GoodsService {

    DBdao db = new GoodsDao();

    // 查询所有手机
    public List<Goods> findAll() {
        String sql = "select * from goods";
        List<Goods> list = db.query(sql);
        return list;
    }

    //查询单个商品
    public Goods findById(int gid) {
        String sql = "select * from goods where gid = "+gid+"";
        Goods g = (Goods) db.findById(sql);
        return g;
    }
}
