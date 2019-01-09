package pers.springtest3.service.Impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import pers.springtest3.entity.Movie;
import pers.springtest3.mapper.IMovieMapper;
import pers.springtest3.service.IMovieService;
import pers.springtest3.util.MybatisUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Eve
 * @Date: 2019/1/3 10:20
 * @Version 1.0
 */
@Service("ims")
public class IMovieServiceImpl implements IMovieService {
    @Override
    public Map<String, Object> findMoviesByPage(Integer current, Integer pageRows) throws IOException {
        SqlSession session = MybatisUtil.getInstance().getSqlSession();
        IMovieMapper mapper = session.getMapper(IMovieMapper.class);
        Map<String,Object> map = new HashMap<>();

        Integer rows = mapper.findTotalRows();
        rows = rows % pageRows == 0 ? (rows/pageRows):(rows/pageRows+1);
        map.put("total",rows);
        int startRows = (current - 1) * pageRows;
        map.put("rows",mapper.findMoviesByPage(startRows,pageRows));
        session.commit();
        session.close();
        return map;
    }

    @Override
    public List<Movie> findAllMovieTest() {
        SqlSession session = null;
        try {
            session = MybatisUtil.getInstance().getSqlSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        IMovieMapper mapper = session.getMapper(IMovieMapper.class);
        List<Movie> list = mapper.findAllMovieTest();
        session.commit();
        session.close();
        return list;
    }
}
