package pers.mybatistest.test;

import org.apache.ibatis.session.SqlSession;
import pers.mybatistest.mapper.ISchoolMapper;
import pers.mybatistest.util.MybatisUtil;

import static org.junit.Assert.*;

public class ISchoolMapperTest {

    @org.junit.Test
    public void addSchool() {
    }

    @org.junit.Test
    public void deleteSchool() {
    }

    @org.junit.Test
    public void updateSchool() {
    }

    @org.junit.Test
    public void findAllSchools() {
        SqlSession session = MybatisUtil.getInstance().getSqlSession();
        ISchoolMapper schoolMapper = session.getMapper(ISchoolMapper.class);
        System.out.println(schoolMapper.findAllSchools());
        session.commit();
        session.close();
    }
}