package com.xagc.mtms.service.Impl;

import com.xagc.mtms.entity.Director;
import com.xagc.mtms.entity.Movie;
import com.xagc.mtms.entity.Type;
import com.xagc.mtms.mapper.IMovieMapper;
import com.xagc.mtms.service.IMovieService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Eve
 * @Date: 2019/1/10 15:20
 * @Version 1.0
 */
@Service("ims")
public class IMovieServiceImpl implements IMovieService {
    @Resource
    private IMovieMapper iMovieMapper;
    @Override
    public void saveType(Type type) {
        iMovieMapper.saveType(type);
    }

    @Override
    public void deleteType(String ids) {
        String[] str = ids.split(",");
        for (String s:
             str) {
            Integer is = Integer.parseInt(s);
            iMovieMapper.deleteType(is);
        }
    }

    @Override
    public void updateType(Type type) {
        iMovieMapper.updateType(type);
    }

    @Override
    public List<Type> findAllTypes() {
        return iMovieMapper.findAllTypes();
    }

    @Override
    public void saveDirector(Director director) {
        iMovieMapper.saveDirector(director);
    }

    @Override
    public void deleteDirector(String ids) {
        System.out.println(ids + "*********************************");
        String[] str = ids.split(",");
        for (String s:
                str) {
            Integer is = Integer.parseInt(s);
            iMovieMapper.deleteDirector(is);
        }
    }

    @Override
    public void updateDirector(Director director) {
        iMovieMapper.updateDirector(director);
    }

    @Override
    public List<Director> findDirectors() {
        return iMovieMapper.findDirectors();
    }

    @Override
    public List<Director> findDirectorByLikeNameOrDesc(String name, String desc) {
        return iMovieMapper.findDirectorByLikeNameOrDesc(name,desc);
    }

    @Override
    public void saveMovie(Movie movie) {
        iMovieMapper.saveMovie(movie);
    }

    @Override
    public void deleteMovie(String ids) {
        String[] str = ids.split(",");
        for (String s:
                str) {
            Integer is = Integer.parseInt(s);
            iMovieMapper.deleteMovie(is);
        }
    }

    @Override
    public void updateMovie(Movie movie) {
        iMovieMapper.updateMovie(movie);
    }

    @Override
    public List<Movie> findMovie() {
        return iMovieMapper.findMovie();
    }
}
