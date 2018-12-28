package pers.test.mybatisservlet.test;

import org.apache.ibatis.session.SqlSession;
import pers.test.mybatisservlet.entity.User;
import pers.test.mybatisservlet.service.IUserService;
import pers.test.mybatisservlet.service.Impl.UserServiceImpl;
import pers.test.mybatisservlet.util.MybatisUtil;
import pers.test.mybatisservlet.mapper.IUserMapper;

import java.io.IOException;

public class IUserMapperTest {

    @org.junit.Test
    public void save() throws IOException {
        SqlSession session = MybatisUtil.getInstance().getSqlSession();
        IUserMapper userMapper = session.getMapper(IUserMapper.class);
        userMapper.save(new User("A","111111","南京"));
        session.commit();
        session.close();
    }

    @org.junit.Test
    public void deleteUser() {
        IUserService i = new UserServiceImpl();
        i.deleteUser(14);
    }

    @org.junit.Test
    public void updateUser() {

    }

    @org.junit.Test
    public void findAllUsers() throws IOException {
        SqlSession session = MybatisUtil.getInstance().getSqlSession();
        IUserMapper userMapper = session.getMapper(IUserMapper.class);
        System.out.println(userMapper.findAllUsers());
        session.commit();
        session.close();
    }
}