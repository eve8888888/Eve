package pers.springone.dao.Impl;

import org.springframework.stereotype.Repository;
import pers.springone.dao.ICarDao;
import pers.springone.entity.Car;

import java.util.List;

/**
 * @Author: Eve
 * @Date: 2019/1/2 9:27
 * @Version 1.0
 */
@Repository("dao")
public class ICarDaoImpl implements ICarDao {
    @Override
    public void save(Car car) {
        System.out.println("已经存储了汽车");
    }

    @Override
    public List<Car> findAllCar() {
        System.out.println("已经找到所有汽车");
        return null;
    }
}
