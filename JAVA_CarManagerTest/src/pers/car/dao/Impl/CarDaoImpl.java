package pers.car.dao.Impl;

import pers.car.dao.ICarDao;
import pers.car.entity.Car;
import pers.car.util.DButil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @Author: Eve
 * @Date: 2018/12/17 14:12
 * @Version 1.0
 */
public class CarDaoImpl implements ICarDao {
    @Override
    public void addCar(Car car) {
        DButil db = DButil.getInstance();
        db.connection();
        String sql = "insert into car_table(CAR_BRAND,CAR_COLOR,CAR_DATE,CAR_PRICE,CAR_PIC,CAR_DESC) values (?,?,?,?,?,?)";
        db.preparedStatement(sql,car.getBrand(),car.getColor()
        ,car.getDate(),car.getPrice(),car.getPic(),car.getDesc());
        db.exeuteUpdate();
        db.close();
    }

    @Override
    public void deleteCar(Integer id) {
        DButil db = DButil.getInstance();
        db.connection();
        String sql = "delete from car_table where car_id = ?";
        db.preparedStatement(sql,id);
        db.exeuteUpdate();
        db.connection();
    }

    @Override
    public void updateCar(Car car, Integer id) {
        DButil db = DButil.getInstance();
        db.connection();
        String sql = "update car_table set car_brand=?," +
                "car_color=?,car_date=?,car_price=?," +
                "car_pic=?,car_desc=? where car_id = ?";
        db.preparedStatement(sql,car.getBrand(),
                car.getColor(),car.getDate(),
                car.getPrice(),car.getPic(),
                car.getDesc(),id);
        db.exeuteUpdate();
        db.connection();
    }

    @Override
    public List<Car> findAllCar() {
        DButil db = DButil.getInstance();

        db.connection();
        String sql = "select * from car_table";
        db.preparedStatement(sql);
        ResultSet rs = db.exeuteQuery();
        List<Car> list = new ArrayList<>();
        Car car = null;
        try {
            while (rs.next()){
                car = new Car(
                        rs.getInt("car_id"),
                        rs.getString("car_brand"),
                        rs.getString("car_color"),
                        rs.getDate("car_date"),
                        rs.getDouble("car_price"),
                        rs.getString("car_pic"),
                        rs.getString("car_desc")
                );
                list.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return list;
    }
}
