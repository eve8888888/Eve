package pers.test.mybatisservlet.service;

import pers.test.mybatisservlet.entity.User;

import java.util.List;

public interface IUserService {
    void save(User user);
    void deleteUser(Integer id);
    void updateUser(User user);
    List<User> findAllUsers();
}
