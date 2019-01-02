package pers.test.mapper;

import pers.test.entity.Movie;

import java.util.List;

/**
 * @Author: Eve
 * @Date: 2018/12/28 9:40
 * @Version 1.0
 */
public interface IMovieMapper {
    List<Movie> findAllMovie();

}
