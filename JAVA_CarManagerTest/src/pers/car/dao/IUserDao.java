package pers.car.dao;

import pers.car.entity.User;

import java.util.List;

public interface IUserDao {
    void save(User user);

    void delete(Integer id);

    void update(User user);

    List<User> findAllUsers();

    User findUserByNameAndPassword(String name, String pwd);

    List<User> findUsersByLikeName(String name);
}
