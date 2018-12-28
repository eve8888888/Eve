package pers.test.mybatisservlet.mapper;

import pers.test.mybatisservlet.entity.User;

import java.util.List;

public interface IUserMapper {
    void save(User user);
    void deleteUser(Integer id);
    void updateUser(User user);
    List<User> findAllUsers();
}
