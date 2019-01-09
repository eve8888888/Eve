package pers.springmvcfinal.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.springmvcfinal.entity.Movie;
import pers.springmvcfinal.entity.Type;
import pers.springmvcfinal.mapper.IMovieMapper;
import pers.springmvcfinal.service.IMovieService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Eve
 * @Date: 2019/1/8 18:28
 * @Version 1.0
 */
@Service("ims")
@Transactional
public class MovieServiceImpl implements IMovieService {
    @Resource
    IMovieMapper iMovieMapper;
    @Override
    public Map<String,Object> findAllMovies(Integer current,Integer pageSize) {
        PageHelper.startPage(current,pageSize);
        List<Movie> list = iMovieMapper.findAll();
        PageInfo<Movie> pf = new PageInfo<>(list);
        long total = pf.getTotal();
        total = total % pageSize == 0 ? total/pageSize : total / pageSize+1;
        Map<String,Object> map = new HashMap<>();
        map.put("list",pf.getList());
        map.put("total",total);
        return map;
    }

    @Override
    public List<Type> findAllType() {
        return null;
    }

    @Override
    public List<Movie> findAllMoviesByType(String movieType) {
        return null;
    }

    @Override
    public List<Movie> findMoviesByLikeNameOrDescOrPrice(String name, String desc, Double min, Double max) {
        return null;
    }

    @Override
    public List<Movie> findMoviesByLike(String name, String desc, Double pricemin, Double pricemax) {
        return null;
    }
}
