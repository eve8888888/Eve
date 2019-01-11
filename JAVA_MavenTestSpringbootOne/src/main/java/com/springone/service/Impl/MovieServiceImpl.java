package com.springone.service.Impl;

import com.springone.entity.Movie;
import com.springone.mapper.IMoveMapper;
import com.springone.service.IMovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2019/1/9 20:29
 * @Version 1.0
 */
@Service
public class MovieServiceImpl implements IMovieService {
    @Resource
    private IMoveMapper iMoveMapper;
    @Override
    public List<Movie> findAllMovies() {
        return iMoveMapper.findAllMovies();
    }
}
