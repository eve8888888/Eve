package pers.service;

import pers.bean.Car;
import pers.dao.CarDao;
import pers.dao.DBdao;

import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/6 9:11
 * @Version 1.0
 */
//购物车的业务类
public class CarService {

    DBdao db = new CarDao();

    /*
     * gid INT COMMENT'关联的商品id',
     * u_id VARCHAR(50) COMMENT'关联的用户id',
     */
    //查询单个
    public Car findById(int gid, String uid){
        String sql = "select * from car where gid="+gid+" and u_id = '"+uid+"'";
        Car c = (Car) db.findById(sql);
        return c;
    }

    //查询购物车
    public void addCar(Car c) {
        //先去查找购物车
        Car car = findById(c.getGid(),c.getU_id());
        if(car!=null){
            //如果点击添加的商品购物车里有，就修改数量
            String sql = "update car set cnum = "+(car.getCnum()+1)+" where cid="+car.getCid()+"";
            db.update(sql);
        }else{
            //如果点击添加的商品购物车里没有，就执行添加操作
            String sql = "insert into car (cmoney,cname,cimage,gid,u_id)"
                    + "values("+c.getCmoney()+",'"+c.getCname()+"',"
                    + "'"+c.getCimage()+"',"+c.getGid()+""
                    + ",'"+c.getU_id()+"')";
            System.out.println("sql=====>"+sql);
            db.update(sql);
        }
    }

    //查询单个用户的购物车
    public List<Car> findById(String uid){
        String sql = "select * from car where u_id = '"+uid+"'";
        List<Car> query = db.query(sql);
        return query;
    }

    //批量删除
    public void delsCar(String cids){
        String sql = "DELETE FROM car WHERE cid IN ("+cids+")";
        db.update(sql);
    }

}

