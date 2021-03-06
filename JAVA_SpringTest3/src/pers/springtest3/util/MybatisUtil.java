package pers.springtest3.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @Author: Eve
 * @Date: 2019/1/3 10:16
 * @Version 1.0
 */
public class MybatisUtil {
    private static MybatisUtil instance;
    private static SqlSessionFactory sqlSessionFactory;
    private MybatisUtil() throws IOException {
        sqlSessionFactory();
    }
    public static MybatisUtil getInstance() throws IOException {
        return instance == null ? new MybatisUtil():instance;
    }

    public static void sqlSessionFactory() throws IOException {
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("configuration.xml"));
    }
    public SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
