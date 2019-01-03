package pers.springone.service.Impl;

import org.springframework.stereotype.Service;
import pers.springone.dao.ICarDao;
import pers.springone.entity.Car;
import pers.springone.service.ICarService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2019/1/2 9:29
 * @Version 1.0
 */
@Service("service")
public class ICarServiceImpl implements ICarService {
    @Resource
    private ICarDao dao;

    public ICarDao getDao() {
        return dao;
    }

    public void setDao(ICarDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(Car car) {
        dao.save(car);
    }

    @Override
    public List<Car> findAllCar() {
        return dao.findAllCar();
    }
}
