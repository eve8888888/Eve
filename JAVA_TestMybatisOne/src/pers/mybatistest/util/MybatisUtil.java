package pers.mybatistest.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2018/12/25 15:25
 * @Version 1.0
 */
public class MybatisUtil {
    private static MybatisUtil instance;
    private static SqlSessionFactory sqlSessionFactory;
    private MybatisUtil(){
        buildSessionFactory();
    }
    public static MybatisUtil getInstance(){
        if(instance == null){
            instance = new MybatisUtil();
        }
        return instance;
    }
    public void buildSessionFactory(){
        try {
            sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("configuration.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
