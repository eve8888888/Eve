package pers.springtest3.service;

import pers.springtest3.entity.Movie;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IMovieService {
    Map<String,Object> findMoviesByPage(Integer current,Integer pageRows) throws IOException;
    List<Movie> findAllMovieTest();
}
