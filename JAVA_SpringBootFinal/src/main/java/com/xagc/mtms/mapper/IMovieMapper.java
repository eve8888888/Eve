package com.xagc.mtms.mapper;

import com.xagc.mtms.entity.Director;
import com.xagc.mtms.entity.Movie;
import com.xagc.mtms.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.w3c.dom.ls.LSException;

import java.util.List;
@Mapper
public interface IMovieMapper {
    /*
    对电影类型的管理接口方法
     */
    void saveType(Type type);
    void deleteType(Integer id);
    void updateType(Type type);
    List<Type> findAllTypes();

    /*
    对导演的管理方法
     */
    void saveDirector(Director director);
    void deleteDirector(Integer id);
    void updateDirector(Director director);
    List<Director> findDirectors();
    List<Director> findDirectorByLikeNameOrDesc(
            @Param("name") String name,
            @Param("desc") String desc);

    /*
    对电影的管理
     */
    void saveMovie(Movie movie);
    void deleteMovie(Integer id);
    void updateMovie(Movie movie);
    List<Movie> findMovie();
}
