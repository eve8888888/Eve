package pers.test.service.Impl;

import org.apache.ibatis.session.SqlSession;
import pers.test.entity.Movie;
import pers.test.mapper.IMovieMapper;
import pers.test.service.IMovieService;
import pers.test.util.MybatisUtil;

import java.io.IOException;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/28 18:37
 * @Version 1.0
 */
public class MovieServiceImpl implements IMovieService {

    @Override
    public List<Movie> findAllMovie() throws IOException {
        SqlSession session = MybatisUtil.getInstance().getSqlSession();
        IMovieMapper i = session.getMapper(IMovieMapper.class);
        List<Movie> list = i.findAllMovie();
        session.commit();
        session.close();
        return list;
    }
}
