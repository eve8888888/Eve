package pers.car.service.Impl;

import pers.car.dao.IManageDao;
import pers.car.dao.Impl.IManageDaoImpl;
import pers.car.entity.Manager;
import pers.car.service.IManageService;

/**
 * @Author: Eve
 * @Date: 2018/12/24 14:20
 * @Version 1.0
 */
public class IManageServiceImpl implements IManageService {
    private IManageDao iManageDao;

    public IManageServiceImpl() {
        iManageDao = new IManageDaoImpl();
    }

    @Override
    public Manager findManageByNameAndPassword(String name, String pwd) {
        return iManageDao.findManageByNameAndPassword(name,pwd);
    }
}
