package com.xagc.mtms.service;

import com.xagc.mtms.entity.Director;
import com.xagc.mtms.entity.Movie;
import com.xagc.mtms.entity.Type;

import java.util.List;

public interface IMovieService {
    /*
对电影类型的管理接口方法
 */
    void saveType(Type type);
    void deleteType(String ids);
    void updateType(Type type);
    List<Type> findAllTypes();

    /*
    对导演的管理方法
     */
    void saveDirector(Director director);
    void deleteDirector(String ids);
    void updateDirector(Director director);
    List<Director> findDirectors();
    List<Director> findDirectorByLikeNameOrDesc(String name, String desc);

    /*
    对电影的管理
     */
    void saveMovie(Movie movie);
    void deleteMovie(String  ids);
    void updateMovie(Movie movie);
    List<Movie> findMovie();
}
