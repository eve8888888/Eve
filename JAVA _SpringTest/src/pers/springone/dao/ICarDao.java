package pers.springone.dao;

import pers.springone.entity.Car;

import java.util.List;

public interface ICarDao {
    void save(Car car);
    List<Car> findAllCar();
}
