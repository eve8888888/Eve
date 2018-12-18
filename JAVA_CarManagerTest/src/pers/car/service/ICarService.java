package pers.car.service;

import pers.car.entity.Car;

import java.util.List;

public interface ICarService {
    void addCar(Car car);
    void deleteCar(String ids);
    void updateCar(Car car, Integer id);
    List<Car> findAllCar();
}
