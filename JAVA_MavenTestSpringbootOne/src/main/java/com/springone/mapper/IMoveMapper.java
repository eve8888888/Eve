package com.springone.mapper;

import com.springone.entity.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface IMoveMapper {
    List<Movie> findAllMovies();
}
