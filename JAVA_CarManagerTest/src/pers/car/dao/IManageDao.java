package pers.car.dao;

import pers.car.entity.Manager;

public interface IManageDao {
    Manager findManageByNameAndPassword(String name, String pwd);
}
