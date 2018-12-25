package pers.car.service;

import pers.car.entity.Manager;

/**
 * @Author: Eve
 * @Date: 2018/12/24 14:19
 * @Version 1.0
 */
public interface IManageService {
    Manager findManageByNameAndPassword(String name, String pwd);
}
