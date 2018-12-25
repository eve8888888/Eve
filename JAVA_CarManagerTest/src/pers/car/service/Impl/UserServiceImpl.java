package pers.car.service.Impl;

import pers.car.dao.IUserDao;
import pers.car.dao.Impl.UserDaoImpl;
import pers.car.entity.User;
import pers.car.service.IUserService;

import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/21 16:52
 * @Version 1.0
 */
public class UserServiceImpl implements IUserService {
    private IUserDao iUserDao;

    public UserServiceImpl() {
        iUserDao = new UserDaoImpl();
    }

    @Override
    public void save(User user) {
        iUserDao.save(user);
    }

    @Override
    public void delete(Integer id) {
        iUserDao.delete(id);
    }

    @Override
    public void update(User user) {
        iUserDao.update(user);
    }

    @Override
    public List<User> findAllUsers() {
        return iUserDao.findAllUsers();
    }

    @Override
    public User findUserByNameAndPassword(String name, String pwd) {
        return iUserDao.findUserByNameAndPassword(name,pwd);
    }

    @Override
    public List<User> findUsersByLikeName(String name) {
        return iUserDao.findUsersByLikeName(name);
    }
}
