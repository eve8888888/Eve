package pers.car.dao;

import pers.car.entity.Car;

import java.util.List;

public interface ICarDao {
    void addCar(Car car);
    void deleteCar(Integer id);
    void updateCar(Car car, Integer id);
    List<Car> findAllCar();
    List<Car> findCarsBynameAndPrice(String brand,Double min,Double max);

}
