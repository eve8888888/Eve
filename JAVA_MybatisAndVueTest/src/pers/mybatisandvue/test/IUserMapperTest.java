package pers.mybatisandvue.test;

import org.apache.ibatis.session.SqlSession;
import pers.mybatisandvue.entity.User;
import pers.mybatisandvue.mapper.IUserMapper;
import pers.mybatisandvue.service.IUserService;
import pers.mybatisandvue.service.Impl.UserServiceImpl;
import pers.mybatisandvue.util.MybatisUtil;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class IUserMapperTest {

    @org.junit.Test
    public void save() {
    }

    @org.junit.Test
    public void updateUser() {
    }

    @org.junit.Test
    public void delUser() {
        IUserService i = new UserServiceImpl();
        i.delUser(11);
    }

    @org.junit.Test
    public void findAllUsers() throws IOException {
        SqlSession session = MybatisUtil.getInstance().getSqlSession();
        IUserMapper iUserMapper = session.getMapper(IUserMapper.class);
        List<User> list = iUserMapper.findAllUsers();
        session.commit();
        session.close();
        System.out.println(list);
    }
}