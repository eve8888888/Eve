package pers.springtest3.mapper;

import org.apache.ibatis.annotations.Param;
import pers.springtest3.entity.Movie;

import java.util.List;

public interface IMovieMapper {
//    根据页码找电影
    List<Movie> findMoviesByPage(@Param("startRow") Integer startRow,@Param("pageRows") Integer pageRows);
    Integer findTotalRows();
}
