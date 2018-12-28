package pers.mybatisandvue.service;

import pers.mybatisandvue.entity.User;

import java.util.List;

public interface IUserService {
    void save(User user);
    void updateUser(User user);
    void delUser(Integer id);
    List<User> findAllUsers();
}
