package pers.mybatisandvue.mapper;

import pers.mybatisandvue.entity.User;

import java.util.List;

public interface IUserMapper {
    void save(User user);
    void updateUser(User user);
    void delUser(Integer id);
    List<User> findAllUsers();

}
