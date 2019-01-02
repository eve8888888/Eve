package pers.springone.service;

import org.springframework.stereotype.Service;
import pers.springone.entity.Car;

import java.util.List;

public interface ICarService {
    void save(Car car);
    List<Car> findAllCar();
}
