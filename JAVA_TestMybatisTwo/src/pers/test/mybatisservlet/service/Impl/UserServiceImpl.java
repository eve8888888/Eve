package pers.test.mybatisservlet.service.Impl;

import org.apache.ibatis.session.SqlSession;
import pers.test.mybatisservlet.entity.User;
import pers.test.mybatisservlet.mapper.IUserMapper;
import pers.test.mybatisservlet.service.IUserService;
import pers.test.mybatisservlet.util.MybatisUtil;

import java.io.IOException;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/26 11:09
 * @Version 1.0
 */
public class UserServiceImpl implements IUserService {
    @Override
    public void save(User user) {
        SqlSession session = null;
        try {
            session = MybatisUtil.getInstance().getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        IUserMapper userMapper = session.getMapper(IUserMapper.class);
        userMapper.save(user);
        session.commit();
        session.close();
    }

    @Override
    public void deleteUser(Integer id) {
        SqlSession session = null;
        try {
            session = MybatisUtil.getInstance().getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        IUserMapper userMapper = session.getMapper(IUserMapper.class);
        userMapper.deleteUser(id);
        session.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        SqlSession session = null;
        try {
            session = MybatisUtil.getInstance().getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        IUserMapper userMapper = session.getMapper(IUserMapper.class);
        userMapper.updateUser(user);
        session.commit();
        session.close();
    }

    @Override
    public List<User> findAllUsers() {
        SqlSession session = null;
        try {
            session = MybatisUtil.getInstance().getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        IUserMapper userMapper = session.getMapper(IUserMapper.class);
        List<User> list = userMapper.findAllUsers();
        session.commit();
        session.close();
        return list;
    }
}
