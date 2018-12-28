package pers.mybatisandvue.service.Impl;

import org.apache.ibatis.session.SqlSession;
import pers.mybatisandvue.entity.User;
import pers.mybatisandvue.mapper.IUserMapper;
import pers.mybatisandvue.service.IUserService;
import pers.mybatisandvue.util.MybatisUtil;

import java.io.IOException;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/27 10:21
 * @Version 1.0
 */
public class UserServiceImpl implements IUserService {
    @Override
    public void save(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void delUser(Integer id) {
        SqlSession session = null;
        try {
            session = MybatisUtil.getInstance().getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        IUserMapper iUserMapper = session.getMapper(IUserMapper.class);
        iUserMapper.delUser(id);
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
        IUserMapper iUserMapper = session.getMapper(IUserMapper.class);
        List<User> list = iUserMapper.findAllUsers();
        session.commit();
        session.close();
        return list;
    }
}
