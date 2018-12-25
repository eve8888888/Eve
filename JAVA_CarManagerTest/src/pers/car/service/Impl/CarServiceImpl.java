package pers.car.service.Impl;

import pers.car.dao.ICarDao;
import pers.car.dao.Impl.CarDaoImpl;
import pers.car.entity.Car;
import pers.car.service.ICarService;

import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/17 15:28
 * @Version 1.0
 */
public class CarServiceImpl implements ICarService {
    private ICarDao iCarDao;

    public CarServiceImpl() {
        iCarDao = new CarDaoImpl();
    }

    @Override
    public void addCar(Car car) {
        iCarDao.addCar(car);
    }

    @Override
    public void deleteCar(String ids) {
        String[] s = ids.split(",");
        for (String  s1: s
             ) {
            iCarDao.deleteCar(Integer.parseInt(s1));
        }

    }

    @Override
    public void updateCar(Car car,Integer id) {
        iCarDao.updateCar(car,id);
    }

    @Override
    public List<Car> findAllCar() {
        return iCarDao.findAllCar();
    }

    @Override
    public List<Car> findCarsBynameAndPrice(String brand, Double min, Double max) {
        return iCarDao.findCarsBynameAndPrice(brand,min,max);
    }

}
